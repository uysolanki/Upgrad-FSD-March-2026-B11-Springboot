package com.upgrad.UpgradB11Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upgrad.UpgradB11Springboot.entity.Supplier;
import com.upgrad.UpgradB11Springboot.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierControllerUI 
{
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/showsupplier")
	public String showsupplier(Model model)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Regal Traders");
		supplier.setSupplierEmail("regal@gmail.com");
		supplier.setSupplierCity("Pune");
		
		model.addAttribute("supp",supplier);
		return "show-suppliers";
	}
	
	@RequestMapping("/showAllSuppliers")
	public String showAllSuppliers(Model model)
	{
		List<Supplier> suppliers= supplierService.getAllSuppliers();
		model.addAttribute("suppliers",suppliers);
		return "show-all-suppliers";
	}
}

//Post - 	Insert
//Put - 	Update
//Delete -	Delete
//Get   - 	Select/Read

//RequestMapping - support all(Insert,Update,Delete,Select)
