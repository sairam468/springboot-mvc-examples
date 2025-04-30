package com.sit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sit.entity.Employee;
import com.sit.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/report")          //GET Mode Handler Method(G)
	public String showReport(Map<String,Object> map) {
		try {
			//use service
			List<Employee>list=empService.showAllEmployees();
			//keep results in shared memory
			map.put("empList", list);
			//return LVN
			return "show_report";
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}

	}

	@GetMapping("/register")   //form launching for addEmployee operation
	public String showEmployeeRegistrationPage(@ModelAttribute("emp")Employee emp) {
		//return LVN
		return "employee_register";
	}

	/*//	Raises Double Posting Problem and Code Reusability

	@PostMapping("/register")  //form submission for addEmployee operation
	public String registerEmployee(Map<String,Object>map,@ModelAttribute("emp")Employee emp) {
		try {
			//use service
			String msg=empService.registerEmployee(emp);
			List<Employee>list=empService.showAllEmployees();
			map.put("empList", list);
			map.put("resultMsg", msg);
			//return LVN
			return "show_report";
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}	
	}*/


	/*// PRG 
	// problem is not printing the message
	@PostMapping("/register")  //form submission for addEmployee operation (POST-P)
	public String registerEmployee(Map<String,Object>map,@ModelAttribute("emp")Employee emp) {
		try {
			//use service
			String msg=empService.registerEmployee(emp);
			map.put("resultMsg", msg);
			//return LVN
			return "redirect:report"; //Redirection-R
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}	
	}*/

	/*//BEST
	// PRG using RedirectAttributes instead of Map
	// negligible problem is msg missing after refreshing

	@PostMapping("/register")  //form submission for addEmployee operation (POST-P)
	public String registerEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp) {
		try {
			//use service
			String msg=empService.registerEmployee(emp);
			attrs.addFlashAttribute("resultMsg", msg);       //Redirection Scope Attribute
			//return LVN
			return "redirect:report"; //Redirection-R
		}
		catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());  //Request Scope Attribute
			return "error";
		}	
	}*/

	// PRG using HttpSession instead of RedirectAttributes
	@PostMapping("/register")  //form submission for addEmployee operation (POST-P)
	public String registerEmployee(HttpSession ses,@ModelAttribute("emp")Employee emp) {
		try {
			//use service
			String msg=empService.registerEmployee(emp);
			ses.setAttribute("resultMsg", msg);
			//return LVN
			return "redirect:report"; //Redirection-R
		}
		catch(Exception e) {
			e.printStackTrace();
			ses.setAttribute("errorMsg", e.getMessage());
			return "error";
		}	
	}

	@GetMapping("/edit")
	public String EditFormPage(@RequestParam("no") int no,
			@ModelAttribute("emp")Employee emp) {
		//use service
		Employee emp1=empService.fetchEmployeeById(no);
		//copy emp1 object data to emp object
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}

	@PostMapping("/edit")
	public String updateEmployeeDetails(@ModelAttribute("emp")Employee emp,
			RedirectAttributes attrs) {
		try {
			//use service
			String msg=empService.editEmployee(emp);
			//Keep the 	result in model Attribute	
			attrs.addFlashAttribute("resultMsg", msg);
			//return LVN
			return "redirect:report";
		}

		catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());  //Request Scope Attribute
			return "error";
		}	
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeDetails(@RequestParam("no")int no,
			                           Map<String,Object>map) {
		try {
		//use service
		String msg=empService.deleteEmployeeById(no);
		//Keep the 	result in model Attribute	
		map.put("resultMsg", msg);
		//return LVN
		return "forward:report";
	}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());  //Request Scope Attribute
			return "error";
		}	
	}	


}
