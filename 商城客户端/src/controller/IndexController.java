package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Commodity;
import entity.User;
import service.StoreService;
import service.UserService;
import util.Constsnt;
import util.Pagination;
@Controller
public class IndexController {
@Autowired
StoreService storeService;


@RequestMapping(value="index")

public String index(String searchName) {
	if(searchName==null){
		
	return "index";
	}
	else if(searchName.equals("ÊÖ»ú")) {
		return "my-class"; 
		
		
	}else {
		
		return "index";
	}
	
	
	
}
@RequestMapping(value="class")
public ModelAndView classify(Commodity comm ,Integer ye,Integer min,Integer max) {
if (ye== null) {
	 	ye = 1;
	}
	int count = storeService.searchCount(comm,min,max);
	
	Pagination p = new Pagination(ye, count, Constsnt.EMP_NUM_IN_PAGE, Constsnt.EMP_NUM_OF_PAGE);

	List<Commodity> list = storeService.search(comm, min , max, p.getBegin(), Constsnt.EMP_NUM_IN_PAGE);
	List<Commodity> list1 = storeService.search1(comm, min , max, p.getBegin(), Constsnt.EMP_NUM_IN_PAGE);

	ModelAndView mv=new ModelAndView("my-class");

    mv.addObject("min",min);
    mv.addObject("max",max);
	mv.addObject("c", comm);
	mv.addObject("p", p);
	mv.addObject("list", list);
	mv.addObject("list1", list1);
   


	
	
	return mv;
}


@RequestMapping(value="detail")
public ModelAndView Detail(Integer id) {	
ModelAndView mv=new ModelAndView("page");
List<Commodity>list=storeService.searchById(id);
mv.addObject("list",list);
return mv;	
}


/*@RequestMapping(value="cart")
public ModelAndView Cart(Integer id) {
	
	ModelAndView mv=new ModelAndView("my-car");
	List<Commodity>list=storeService.searchById(id);
	mv.addObject("list",list);
	return mv;	
	
}*/



}
