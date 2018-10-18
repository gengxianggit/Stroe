package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Department;
import entity.Employee;

public interface EmployeeService {
	public int searchCount(Employee condition);

	public List<Department> searchCountDep();

	public List<Employee> search(Employee condition, int begin, int empNumInPage);

	public void add(Employee emp);

	public Employee searchEmpById(int id);

	public void update(Employee emp);

	public void delete(String ids);

	public void updateList(List<Employee> list);
}
