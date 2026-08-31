package com.upgrad.UpgradB11Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.UpgradB11Springboot.entity.Supplier;
import com.upgrad.UpgradB11Springboot.service.SupplierService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/supplier")
public class SupplierControllerReact 
{
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public String login(
	        @RequestParam String username,
	        @RequestParam String password,
	        HttpServletRequest request) {

		System.out.println("Hi...");
	    UsernamePasswordAuthenticationToken token =
	            new UsernamePasswordAuthenticationToken(username, password);

	    Authentication authentication =
	            authenticationManager.authenticate(token);

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    request.getSession().setAttribute(
	            "SPRING_SECURITY_CONTEXT",
	            SecurityContextHolder.getContext()
	    );

	    return "Login successful";
	}
	
	@GetMapping("/getAllSuppliers")  
	public List<Supplier> getAllSuppliers(){
		List<Supplier> suppliers= supplierService.getAllSuppliers();
		return suppliers;
	}
	
	
	@PostMapping("/saveSuppliers")   //Insert Data
	public List<Supplier> saveSuppliers(@RequestBody List<Supplier> suppliers){
		return supplierService.saveSuppliers(suppliers);
	}

}

//Post - 	Insert
//Put - 	Update
//Delete -	Delete
//Get   - 	Select/Read

//RequestMapping - support all(Insert,Update,Delete,Select)
