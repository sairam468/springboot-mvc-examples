package com.sit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sit.entity.Employee;
import com.sit.repository.IEmployeeRepository;

@Service
public class EmplyeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Page<Employee> getEmpbyPage(Pageable page) {
		return empRepo.findAll(page);
	}

	
	
	}
