package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Department;

public interface DepartmentService {

	public int searchDepCount(Department condition);

	public List<Department> search(Department condition, int begin, int empNumInPage);

	public  void add(Department dep);

	public Department searchDepById(int id);

	public void update(Department dep);

	public void delete(String ids);

	
	
}
