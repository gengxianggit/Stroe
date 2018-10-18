package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Department;
import service.DepartmentService;
import util.Constsnt;
import util.Pagination;

@Controller
@RequestMapping(value="dep")
public class DepartmentController {
     @Autowired
	DepartmentService depService;
	
	@RequestMapping(value="search")
	public  ModelAndView search(Department condition,Integer ye) {

		
	
		if (ye== null) {
			ye = 1;
		}
		int count = depService.searchDepCount(condition);

		Pagination p = new Pagination(ye, count, Constsnt.EMP_NUM_IN_PAGE, Constsnt.EMP_NUM_OF_PAGE);
		List<Department> list = depService.search(condition, p.getBegin(), Constsnt.EMP_NUM_IN_PAGE);
	ModelAndView mv=new ModelAndView("dep/department");
	  mv.addObject("c", condition);
	   mv.addObject("p", p);
	   mv.addObject("list", list);
	   
	   
	   return mv;
		
	}
	@RequestMapping(value="showAdd")
	public String showDepAdd() {
		
		return "dep/addview";
		
	}
	@RequestMapping(value="add")
	public String add(Department dep) {

		
		
		depService.add(dep);
		 

		return "redirect:/dep/search.do";
		
	}
	@RequestMapping(value="showUpdate")	
	public ModelAndView showDepUpdate(int id)
	{

		
		
		Department dep=depService.searchDepById(id);
		ModelAndView mv=new ModelAndView("dep/update");
		mv.addObject("dep",dep);
		 
		  
		return mv;

	}
	@RequestMapping(value="update")
	public String update(Department dep) {

		
		
		depService.update(dep);
		 

		return "redirect:/dep/search.do";
		
	}
	@RequestMapping(value="delete")
	public String  deletebatch(String ids) {

		
		
		
		depService.delete(ids);
		

		return "redirect:/dep/search.do";

	}

}
