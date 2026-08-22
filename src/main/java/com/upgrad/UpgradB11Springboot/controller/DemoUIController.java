package com.upgrad.UpgradB11Springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoUIController {

	@RequestMapping("/home")
	public String home()
	{
		return "home";   //name of the (.html) webpage
	}
	
	@RequestMapping("/supplier")
	public String showSupplier(Model model)
	{
		String player="Rohit";
		model.addAttribute("player",player);
		return "show-suppliers";   //name of the (.html) webpage
	}
//	
//	@RequestMapping("/welcomeSupplier")
//	public String showSupplier()
//	{
//		String supplierName="Royal traders";
//		return "show-suppliers";   //name of the (.html) webpage
//	}
}
