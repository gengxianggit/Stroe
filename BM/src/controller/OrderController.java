package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Order;
import service.OrderService;

@Controller
public class OrderController {
@Autowired OrderService os;

@RequestMapping("showorder")
public ModelAndView showorder() {
	ModelAndView mv=new ModelAndView("Orderform");
	List<Order>olist=os.searchAll();
	mv.addObject("olist", olist);
      return mv;	
}
@RequestMapping("orderdetailed")
public ModelAndView orderdetailed(int id) {
	ModelAndView mv=new ModelAndView("order_detailed");
	Order order=os.search(id);
	mv.addObject("order", order);
	return mv;
	
	
}
@RequestMapping("searchNN")
public ModelAndView search(String num,String time) {
	
	ModelAndView mv=new ModelAndView("Orderform");
	List<Order>olist=os.searchNN(num,time);
	mv.addObject("olist", olist);
      return mv;	
	
	
	
}
@RequestMapping("fahuo")
@ResponseBody
public boolean fahuo(int id) {
	
boolean flag=os.updateFauo(id);
	return flag;
}
}
