package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentDao dao;
	@Autowired
	EmployeeDao empDao;
	
	@Override
	public int searchDepCount(Department condition) {
		// TODO Auto-generated method stub
		
		
		int count =dao.searchDepCount(condition);
		
		
		return count;
		
	}

	@Override
	public List<Department> search(Department condition, int begin, int empNumInPage) {
		// TODO Auto-generated method stub
		
		
		List<Department> depList=dao.search(condition, begin, empNumInPage);
		
		
		return depList;
	}

	@Override
	public void add(Department dep) {
		// TODO Auto-generated method stub
		
		
		dao.add(dep);
		
		
		
	}

	@Override
	public Department searchDepById(int id) {
		// TODO Auto-generated method stub
		
		
		Department dep=	dao.searchDepById(id);
		
		
		return dep;
	}

	@Override
	public void update(Department dep) {
		// TODO Auto-generated method stub
		
		
		dao.update(dep);
		
		
		
	}

	@Override
	public void delete(String ids) {
		// TODO Auto-generated method stub
		
		
        

		dao.delete(ids);
		empDao.updateByDepId(ids);
		
		
		
	}

}
