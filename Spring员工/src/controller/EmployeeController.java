 package controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entity.Department;
import entity.Employee;
import service.EmployeeService;
import util.Constsnt;
import util.Pagination;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="emp")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
      
//	public void test(@RequestParam(value="ming")String name,Integer age) {
//		System.out.println(name);
//}	
//	
//@RequestMapping(value="hello1")
//public void test1(Employee emp) {
//	
//System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getSex());
//	
//	
//}
//	
//
@RequestMapping(value="search")

public ModelAndView search(Employee condition,Integer ye) {

	
	
	
	

	if (ye== null) {
	 	ye = 1;
	}
	int count = empService.searchCount(condition);
	List<Department> depList = empService.searchCountDep();
	Pagination p = new Pagination(ye, count, Constsnt.EMP_NUM_IN_PAGE, Constsnt.EMP_NUM_OF_PAGE);

	List<Employee> list = empService.search(condition, p.getBegin(), Constsnt.EMP_NUM_IN_PAGE);

	ModelAndView mv=new ModelAndView("emp/employee");

	mv.addObject("depList", depList);
	mv.addObject("c", condition);
	mv.addObject("p", p);
	mv.addObject("list", list);



     return mv;


}

@RequestMapping(value="showAdd3")
private ModelAndView showAdd() {
	// TODO Auto-generated method stub

	
	List<Department> depList = empService.searchCountDep();

	ModelAndView mv=new ModelAndView("emp/addview");

	mv.addObject("depList", depList);


	
     return mv;
	
}
@RequestMapping(value="add")
public String add(Employee emp,@RequestParam(value="photo") MultipartFile[]files) {


	
	String path = "f:/tu/";
	String newName=null;
	for (MultipartFile file:files) {
		if(!file.isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String oldName = file.getOriginalFilename();
			newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));
		  try {
			file.transferTo(new File(path+newName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			}
        emp.setImg(newName);
	
	
	
	empService.add(emp);
	

}


	return "redirect:/emp/search.do";	
}

@RequestMapping(value="showupdate")
public ModelAndView  showUpodate(int id) {


	
	Employee emp=empService.searchEmpById(id);
	List<Department> depList = empService.searchCountDep();
	ModelAndView mv=new ModelAndView("/emp/update");
	mv.addObject("emp",emp);
	mv.addObject("depList",depList);


	return mv;

}
@RequestMapping(value="update")
public String  update(Employee emp) {
	

	
	
	Department dep = new Department();
	empService.update(emp);


	return "redirect:/emp/search.do";

}
@RequestMapping(value="delete")
public String  delete(String ids) {

	
	empService.delete(ids);


	return "redirect:/emp/search.do";
	
}
	
@RequestMapping(value="updatebatch")
@ResponseBody
  public List<Employee> updatebatch(@RequestBody List<Employee>list){

	
	empService.updateList(list);

	
      return  list;
	
}

@RequestMapping(value="showAdd1")
public ModelAndView showAdd1() {

	
	List<Department> depList = empService.searchCountDep();

	ModelAndView mv=new ModelAndView("emp/addview2");

	mv.addObject("depList", depList);


	
     return mv;
	

	
}


@RequestMapping(value="upload")
@ResponseBody
private String  upload(@RequestParam(value="file") MultipartFile[]files) {

  String path = "f:/tu/";
  String newName=null;
	for(MultipartFile file:files) {
		String oldName=file.getOriginalFilename();
		UUID uuid= UUID.randomUUID();
		newName=uuid.toString()+oldName.substring(oldName.indexOf("."));
		try {
			file.transferTo(new File(path+newName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
      return newName;
}

@RequestMapping(value="add2")
public String  add2(Employee emp) {

	
	empService.add(emp);


	return "redirect:/emp/search.do";

}
@RequestMapping(value="deleteFile")
@ResponseBody
private boolean deleteFile(String fileName ) {
	// TODO Auto-generated method stub

	
	File file = new File("f:/tu/" + fileName);

	boolean flag = false;
	// 判断是否为空 //有没有发现讨论基本一样
	if (file.exists()) {
		file.delete();
		flag = true;
	}
	
	return flag;

}
}
//
//
//
//
//
