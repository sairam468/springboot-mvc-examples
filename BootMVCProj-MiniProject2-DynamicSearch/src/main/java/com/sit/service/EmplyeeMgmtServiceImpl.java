package com.sit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.sit.entity.Employee;
import com.sit.repository.IEmployeeRepository;

@Service
public class EmplyeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> showAllEmployees() {

		List<Employee> list=StreamSupport.stream(empRepo.findAll().spliterator(), false).toList();
		//return list.stream().sorted().toList();     //natural Sorting

		return list.stream().sorted((emp1,emp2)->emp1.getEname().compareTo(emp2.getEname())).toList(); //sorting Based on empName
	}

	@Override
	public String registerEmployee(Employee emp) {
		//Use Service
		int idVal=empRepo.save(emp).getEmpno();
		return "Employee is registered with ID Value "+idVal;
	}

	@Override
	public Employee fetchEmployeeById(int id) {
		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Data"));
	}

	@Override
	public String editEmployee(Employee emp) {
		Optional<Employee> op=empRepo.findById(emp.getEmpno());
		if(op.isPresent()) {
			empRepo.save(emp);
			return emp.getEmpno()+" employee is updated";
		}
		return emp.getEmpno()+" employee is not found for updation";
	}

	@Override
	public String deleteEmployeeById(int id) {
		Optional<Employee> op=empRepo.findById(id);
		if(op.isPresent()) {
			empRepo.deleteById(id);
			return id+" employee is deleted";
		}
		return id+" employee is not found for deletion";
	}

	@Override
//	public List<Employee> showEmployeeDynamicSearch(Employee e) {
//	    // Log the initial state of the fields before any changes
//	    System.out.println("Initial Search Criteria: " + e);
//
//	    // Check if the 'ename' field is empty and set it to null if so
//	    if (e.getEname() != null && e.getEname().isEmpty()) {
//	        e.setEname(null);
//	    }
//
//	    // Check if the 'job' field is empty and set it to null if so
//	    if (e.getJob() != null && e.getJob().isEmpty()) {
//	        e.setJob(null);
//	    }
//
//	    // Ensure deptno is valid (non-zero). If it's zero or null, set it to null.
//	    if (e.getDeptno() == null || e.getDeptno() == 0) {
//	        e.setDeptno(null);
//	    }
//	    
//	    // Log the adjusted fields
//	    System.out.println("Adjusted Search Criteria: " + e);
//
//	    // Use ExampleMatcher to ignore null values
//	    Example<Employee> example = Example.of(e, ExampleMatcher.matching()
//	            .withIgnoreNullValues() // Ignore null fields while matching
//	            .withIgnoreCase() // Optionally ignore case for string fields like 'ename' and 'job'
//	    );
//
//	    // Log the Example object to check what fields are actually being searched
//	    System.out.println("Example created for search: " + example);
//
//	    // Return the list of employees that match the dynamic search criteria
//	    List<Employee> employees = empRepo.findAll(example);
//
//	    // Log the results
//	    System.out.println("Search Results: " + employees);
//
//	    return employees;
//	}
	public List<Employee> showEmployeeDynamicSearch(Employee e) {
	    return empRepo.searchEmployees(e.getEname(), e.getJob(), e.getDeptno());
	}


	
	
	}
