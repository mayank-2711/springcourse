package com.mayank.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mayank.springmvcboot.model.Alien;

import jakarta.servlet.http.*;


@Controller
public class HomeController {
	
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
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("a") Alien a) {
		
		return "result";
	}
	
	@GetMapping("/getAliens")
	public String getAliens(Model m) {
		List<Alien> aliens = Arrays.asList(new Alien(101, "Mayank"), new Alien(102, "Navin"));
		m.addAttribute("result", aliens);
		return "showAliens";
	}

}
