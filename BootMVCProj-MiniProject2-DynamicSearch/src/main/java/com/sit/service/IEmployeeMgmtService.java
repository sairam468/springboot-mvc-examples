package com.sit.service;

import java.util.List;

import com.sit.entity.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> showAllEmployees();
	
	public String registerEmployee(Employee emp);
	
	public Employee fetchEmployeeById(int id); 
	
	public String editEmployee(Employee emp);
	
	public String deleteEmployeeById(int id);
	
	public List<Employee> showEmployeeDynamicSearch(Employee e);
}
