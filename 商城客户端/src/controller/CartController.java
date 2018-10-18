package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Commodity;
import entity.ShopCart;
import service.CartService;
import service.StoreService;
import service.UserService;

@Controller
public class CartController {
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	StoreService storeService;
	@RequestMapping(value="cart")
	public ModelAndView Cart(HttpSession session) {
		ModelAndView mv = null;
		if(session.getAttribute("userNameSession")==null) {
			mv=new ModelAndView("login");
			
			
		}else {
		
	    String userName=(String) session.getAttribute("userNameSession");
	    
	    int id=userService.searchId(userName);
	       ShopCart cart=cartService.searchCart(id);
	       int commoNum=0;
	       if(cart!=null) {
	    	   commoNum= cartService.serachCommodityIdNum(cart.getId());  
	       }
			
			mv=new ModelAndView( "my-car");
			 mv.addObject("cart", cart);
			
			 session.setAttribute("commNum", commoNum);
			
		}
		
		return mv;
	}
	@RequestMapping(value="addcart")
	public String docart( HttpSession session,int id,int num) {
		if(session.getAttribute("userNameSession")==null) {
			return "login";
			
		}else {
		
		
		
		String userName=(String) session.getAttribute("userNameSession");
		int uid=userService.searchId(userName);
		int cartId= cartService.searchCartId(uid);
		boolean flag=cartService.serachCommodityId(cartId,id);
		if(flag) {
			cartService.updateCart(id,num);
		}else {
		  List<Commodity>commlist=storeService.searchById(id);
		  Commodity comm=commlist.get(0);
		     
		      double subtotal=num* comm.getPrice();
		    cartService.add(comm, cartId,num,subtotal);
		    
		
		}
		
		
		return "redirect:cart.do";
		}
		
		
		
		
	}
	@RequestMapping(value="deletecart")
	public String deleteCart(HttpSession session,int id) {
		int cartId=(int) session.getAttribute("cartId");
		cartService.deleteCart(id,cartId);
		return "redirect:cart.do";
		
	}
	
	@RequestMapping(value="deletecartAll")
	public String deleteCart(HttpSession session,String ids) {
		int cartId=(int) session.getAttribute("cartId");
		cartService.deleteCartDetail(ids, cartId);
		return "redirect:cart.do";
		
	}
	@RequestMapping(value="addButton")
	@ResponseBody
	public boolean addButton(Integer num,Integer id,double subtotal) {
		
		 int  rs= cartService.updateNum(num,id,subtotal);
		return rs>0;
		
	}
	@RequestMapping(value="updateSumcount")
	public String updateSumcount(double sumCount) {
		
		cartService.updateSumcount(sumCount);
		
		return "redirect:cart.do";
	}
	
}
