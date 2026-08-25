package com.upgrad.UpgradB11Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@RequestMapping("/addSupplierForm")
	public String addSupplierForm(Model model)
	{
	Supplier supplier=new Supplier();
	model.addAttribute("supplier",supplier);
	return "add-supplier-form";
	}

	
	@RequestMapping("/showAllSuppliers")
	public String showAllSuppliers(Model model)
	{
		List<Supplier> suppliers= supplierService.getAllSuppliers();
		model.addAttribute("suppliers",suppliers);
		return "show-all-suppliers";
	}
	
	@PostMapping("/saveSupplier")
	public String saveSupplier(@ModelAttribute Supplier supplier)
	{
		supplierService.saveSupplier(supplier);
		return "redirect:/supplier/showAllSuppliers";
	}
	
	@RequestMapping("/deletSupplier/{suppId}")							//D
	public String deleteSupplierById(@PathVariable int suppId)
	{	
		supplierService.deleteSupplierById(suppId);
		return "redirect:/supplier/showAllSuppliers";
	}
	
	@RequestMapping("/updateSupplierForm/{suppId}")							//D
	public String updateSupplierForm(@PathVariable int suppId,Model model)
	{	
		Supplier supplier=supplierService.getSingleSupplier(suppId);
		model.addAttribute("supplier", supplier);
		return "update-supplier-form";
	}
	
	@PostMapping("updateSupplier/{suppId}")										//U
	public String updateSupplier(@PathVariable int suppId, @ModelAttribute Supplier newValues)
	{
		
		supplierService.updateSupplier(suppId,newValues);
		return "redirect:/supplier/showAllSuppliers";
	}
}

//Post - 	Insert
//Put - 	Update
//Delete -	Delete
//Get   - 	Select/Read

//RequestMapping - support all(Insert,Update,Delete,Select)
