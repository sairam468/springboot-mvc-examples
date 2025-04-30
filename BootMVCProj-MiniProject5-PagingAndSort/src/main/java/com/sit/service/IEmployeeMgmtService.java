package com.sit.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sit.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Page<Employee> getEmpbyPage(Pageable page);
}
