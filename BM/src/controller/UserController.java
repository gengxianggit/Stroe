package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.BmUser;
import service.UserService;

@Controller

public class UserController {

@Autowired UserService userservice;	
	
@RequestMapping("login")
public String login() {
	return "login";
}
	
@RequestMapping("dologin")
public String dologin(BmUser user) {
	boolean flag=userservice.search(user);
	if(flag) {
	return "redirect:index.do";
	}
	else {
	 	
		 return "login";
		
	}
}
}
