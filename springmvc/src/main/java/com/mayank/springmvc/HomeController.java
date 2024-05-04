package com.mayank.springmvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayank.springmvc.dao.AlienDao;
import com.mayank.springmvc.model.Alien;


@Controller
public class HomeController {
	
	@Autowired
	private AlienDao dao;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Aliens");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		
		int num3 = i + j;
		m.addAttribute("num3", num3);
		
		return "result";
	}
	
	@GetMapping("/getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result", dao.getAliens());
		return "showAliens";
	}
	
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("a") Alien a) {
		
		return "result";
	}

}
