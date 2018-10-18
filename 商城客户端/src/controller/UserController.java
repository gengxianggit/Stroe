package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.CartService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	CartService cs;
	@RequestMapping(value="register")
	public String register() {
	
		
		
	return "register";
	}
	@RequestMapping(value="doRegister")
	public String  doRegister(User user) {
		
		boolean flag=userService.addUser(user);
	     int id=userService.searchId(user.getUserName());
		
		userService.addCart(id);
		
		return "login";
		
	}
	@RequestMapping(value="login")
	public String login() {
	
		
		
	return "login";
	}
	@RequestMapping(value="doLogin")
	public String  doLogin(HttpSession session,User user) {
		boolean flag=userService.doLogin(user);
		int uid=userService.searchId(user.getUserName());
		int cartId=cs.searchCartId(uid);
		
		if(flag) {
	session.setAttribute("userNameSession", user.getUserName());
	session.setAttribute("userId",uid);
	session.setAttribute("cartId",cartId);
		return "redirect:cart.do";
		}else {
			
			return "login";	
			
		}
		
		
	}
	
}
