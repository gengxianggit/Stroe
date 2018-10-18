package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.BmUser;
import service.UMService;

@Controller
public class UserManageController {
@Autowired UMService ums;
@RequestMapping("umshow")
public ModelAndView umshow() {
	ModelAndView mv=new ModelAndView("user_list");
	List<BmUser> umList=ums.searchAll();
	
	mv.addObject("umList", umList);
	return mv;
	
}
@RequestMapping("searchCon")
public ModelAndView searchCon(String name) {
	
	ModelAndView mv=new ModelAndView("user_list");
	List<BmUser> umList=ums.searchName(name);
	
	mv.addObject("umList", umList);
	return mv;
	
}
@RequestMapping("deleteUser")

public String  deleteUser(String ids) {
	boolean flag=ums.deleteUser(ids);
	
	return "redirect:umshow.do";
}
@RequestMapping("adduser")
public String adduser(BmUser user) {
	ums.add(user);
	return "redirect:umshow.do";
	
}
}
