package com.sit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sit.dao.ISeasonDAO;

@Controller
public class ShowHomeController {
	
	@Autowired
	private ISeasonDAO s;
	
	@RequestMapping("/")
	public String showHome() {
		//return LVN
		return "WelCome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> m) {
		String msg=s.ShowSeason();
		m.put("msg", msg);
		return "season";
	}
	
	

}
