package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartmentDao;
import dao.EmployeeDao;

import entity.Department;
import entity.Employee;
import service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao dao;
@Override
	public int searchCount(Employee condition) {
        
       
       int count= dao.searchCount(condition);
       
       
		return count;
	}

	@Override
	public List<Department> searchCountDep() {
		// TODO Auto-generated method stub
		
       
        List<Department>deplist=dao.searchCountDep(); 
       
       
		return deplist;
	}

	@Override
	public List<Employee> search(Employee condition, int begin, int empNumInPage) {
		
       
        List<Employee>empList=dao.search(condition, begin, empNumInPage);
       
       
		return empList;
	}

	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		
       
        dao.add(emp);
       
       
	}

	@Override
	public Employee searchEmpById(int id) {
		
       
        Employee emp=dao.searchEmpById(id);
       
       
		return emp;
	}

	@Override
	public void update(Employee emp) {
		
       
        dao.update(emp);
       
       
	}

	@Override
	public void delete(String ids) {
		
       
        
        dao.delete(ids);
        
       
       
		
	}

	@Override
	public void updateList(List<Employee> list) {
		// TODO Auto-generated method stub
		
       
        dao.updateList(list);
       
       
		
	}

}
