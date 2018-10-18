package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entity.Img;
import entity.Production;
import service.ProductionService;

@Controller
public class ProductionController {
@Autowired ProductionService pservice;
@RequestMapping(value="index")
public String index() {
	
	 
	return "index";
	
	
	
	
}
@RequestMapping(value="showProduct")
public ModelAndView  showProduct() {
	
	 List<Production>pList=pservice.searchAll();
	 pservice.deleteLing();
	 ModelAndView mv=new ModelAndView("Products_List");
	
	 mv.addObject("pList", pList);
 	return mv;
}
@RequestMapping("deleteProduction")
public String deleteProduction(int id) {
	
List<Img>iList=pservice.searchImg(String.valueOf(id));
   deleteFile(iList.get(0).getPath());
	boolean flag=pservice.deleteById(id);
	
	return "redirect:showProduct.do";
	
}
@RequestMapping("showAdd")
public String showAdd() {
	
	
return "picture-add";	
}
@RequestMapping("add")
public String add(Production pro) {
	boolean flag=pservice.add(pro);
	
	
	return "redirect:showProduct.do";
	
}
@RequestMapping("showHome")
public ModelAndView showHome() {
	ModelAndView mv =new ModelAndView("home");
	int userCount=pservice.searchUser();
	int orderCount=pservice.searchOrderCount();
	int payCount=pservice.searchPayCount();
	mv.addObject("userCount", userCount);
	mv.addObject("orderCount", orderCount);
	mv.addObject("payCount", payCount);
    	return mv ;
 	
	
}
@RequestMapping("deleteBatch")
public String deleteBatch(String ids) {
	List<Img>iList=pservice.searchImg(ids);
	for(Img img:iList) {
		   deleteFile(img.getPath());
	}
	
	boolean flag=pservice.deleteByIds(ids);
	return "redirect:showProduct.do";
	
	
}

@RequestMapping("upload")
@ResponseBody
public List<Img> upload(@RequestParam(value="photo") MultipartFile[]files){
	List<Img>list=new ArrayList();
	
	String path = "f:/tu/";
		String newName=null;
		
		int i=0;
		for (MultipartFile file:files) {
			if(!file.isEmpty()) {
				i++;
				Img img=new Img();
				UUID uuid = UUID.randomUUID();
				String oldName = file.getOriginalFilename();
				newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));
			    img.setPath(newName);
	            img.setOrder(i);
	             list.add(img);
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
}
		pservice.addImg(list);	
		
		
		return list;
		}

@RequestMapping("deleteFile")
@ResponseBody
public boolean deleteFile(String path) {
	File file=new File("f:/tu/"+path);
	boolean flag=false;
	if(file.exists()) {
		
	    	file.delete();
		flag=true;
		pservice.deleteImg(path);
	}
	
	
	return flag;
}


@RequestMapping("showUpdate")

public ModelAndView showUpdate(int id){
	ModelAndView mv=new ModelAndView("updateProduction");
	Production pro=new Production();
	pro=pservice.searchProduction(id);
	mv.addObject("pro", pro);
	
	return mv;
}
@RequestMapping("updateProduction")
public String updateProduction(Production pro) {
	
	pservice.updateProduction(pro);
	return"redirect:showProduct.do";
}

@RequestMapping("search")
@ResponseBody
public ModelAndView  search(String name) {
	
	 List<Production>pList=pservice.search(name);
	 ModelAndView mv=new ModelAndView("Products_List");
	mv.addObject("pList", pList);
	return mv;
}
@RequestMapping("updateupload")
@ResponseBody
public List<Img> updateupload(@RequestParam(value="photo") MultipartFile[]files){
	List<Img>list=new ArrayList();
	
	String path = "f:/tu/";
		String newName=null;
		
		int i=0;
		for (MultipartFile file:files) {
			if(!file.isEmpty()) {
				i++;
				Img img=new Img();
				UUID uuid = UUID.randomUUID();
				String oldName = file.getOriginalFilename();
				newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));
			    img.setPath(newName);
	            img.setOrder(i);
	             list.add(img);
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
}
		pservice.addImg(list);	
		
		
		return list;
		}

@RequestMapping("updateImg")
@ResponseBody
public boolean updateImg(Img img) {
boolean flag=pservice.updateImg(img);
return flag;
}

}