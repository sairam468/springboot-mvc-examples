package com.sit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sit.entity.Employee;
import com.sit.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	   @GetMapping("/report")     
	   public String ShowEmployeeReport(@PageableDefault(page=0,size=5,sort="job",direction=Sort.Direction.ASC) Pageable pageable,Map<String,Object> m) {
		   System.out.println("EmployeeOperationsController.ShowEmployeeReport()");
		   Page<Employee> p=empService.getEmpbyPage(pageable);
		   m.put("empData",p);
		   
		return "show_report";
		   
		   
	   }

}
