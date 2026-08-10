package com.upgrad.UpgradB11Springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/fsd")
	public String test()
	{
		return "Welcome to springboot";
	}
	
	@RequestMapping("/rcb")
	public String rcb()
	{
		return "Welcome Virat Kohli to RCB";
	}
	
	@RequestMapping("/mi")
	public String mi()
	{
		return "Welcome Rohit Kohli to MI";
	}
	
	@RequestMapping("/ipl")
	public String ipl()
	{
		return "RCB - Virat <br>"
				+ "MI - Rohit <br>"
				+ "CSK - Dhoni";
	}

}
