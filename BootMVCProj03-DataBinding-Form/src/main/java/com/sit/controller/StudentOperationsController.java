package com.sit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sit.modal.Student;

@Controller
public class StudentOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStuFormPage() {
		return "stu_register";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> m,@ModelAttribute("stu") Student stu) {
		System.out.println(stu);
		return "show_result";
	}
	
}
