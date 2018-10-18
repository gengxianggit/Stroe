package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Address;
import entity.Area;
import entity.City;
import entity.Order;
import entity.Province;
import entity.ShopCart;
import entity.ShopCartDetail;
import service.CartService;
import service.DingDanService;
import service.StoreService;
import util.GenerateOrderNo;

@Controller
public class DingDanController {
@Autowired
DingDanService dds;
@Autowired
StoreService ss;
@Autowired
CartService cs;
@RequestMapping(value="setorder")
public ModelAndView SerachDingDan(HttpSession session) {
	ModelAndView mv=new ModelAndView("my-dingdan");
     int userId=(int) session.getAttribute("userId");
     List<Order> olist= dds.searchOrder(userId);
     mv.addObject("olist", olist);
     
	return mv;
	
}
@RequestMapping(value="addorder")
public String addorder(HttpSession session,Order order,String ids) {
	String orderName=GenerateOrderNo.generate();
	int userId=(int) session.getAttribute("userId");
	int cartId=(int) session.getAttribute("cartId");
  Date date=new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String str = format.format(date);
  order.setOrderName(orderName);
  order.setDate(str);
  order.setUserId(userId);
 int rs=dds.add(order);
 int oid=order.getId();
 List<ShopCartDetail> sclist=cs.searchSc(ids,cartId);
boolean flag=dds.addOrderDetail(sclist,oid);
boolean flag1=cs.deleteCartDetail(ids,cartId);
	
return "redirect:setorder.do";
}
@RequestMapping(value="order")
public ModelAndView DingDanorder(HttpSession session,String ids,int num) {
	ModelAndView mv=null;
	
	
	 mv=new ModelAndView("my-add");
    int userId=(int) session.getAttribute("userId");
      ShopCart dd= dds.searchByIds(ids,userId);
      List<Province>plist=dds.searchP();
      List<Address> alist=dds.searchAddress(userId);
     
      mv.addObject("alist", alist);
      mv.addObject("plist", plist);
   
	  mv.addObject("dd", dd);
	
	
	
	return mv;
	
}

@RequestMapping(value="jilian")
@ResponseBody
public List<City> jilian(String province){
	
	List<City>cList=dds.searchCity(province);
	
	return cList;
	
	
}
@RequestMapping(value="jilian2")
@ResponseBody
public List<Area> jilian2(String city){
List<Area> cList=dds.searchCounty(city);
	
	return cList;
	
	
}
@RequestMapping(value="addAdress")
@ResponseBody
public boolean addAdress(HttpSession session,Address adr) {
	int userId=(int) session.getAttribute("userId");
	boolean flag=dds.addAdress(adr,userId);
	return flag;
	
}
@RequestMapping(value="deleteAddress")
@ResponseBody
public boolean deleteAddress(int id) {
	dds.deleteAddress(id);
	return true;
	
}
@RequestMapping(value="deleteod")
public String deleteod(int id) {
	
	  dds.deleteod(id);
	
	return "redirect:setorder.do";
}


}