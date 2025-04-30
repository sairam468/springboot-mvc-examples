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
	public List<Employee> showEmployeeDynamicSearch(Employee e) {
		
		if (e.getEname().length()== 0 || e.getEname().equalsIgnoreCase("")) {
		    e.setEname(null);
		}

		if (e.getJob().length()== 0 || e.getJob().equalsIgnoreCase("")) {
		    e.setJob(null);
		}

		if (e.getDeptno() == null || e.getDeptno() == 0) {
		    e.setDeptno(null);
		}
		Example<Employee> example = Example.of(e);
		List<Employee> employees = empRepo.findAll(example);

		return employees;
	}

	
	
	}
