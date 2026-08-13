package com.upgrad.UpgradB11Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.UpgradB11Springboot.entity.Supplier;
import com.upgrad.UpgradB11Springboot.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController 
{
	@Autowired
	SupplierService supplierService;
	
	@PostMapping("/saveSupplier")   //Insert Data
	public Supplier saveSupplier(@RequestBody Supplier s1){
		return supplierService.saveSupplier(s1);
	}
	
	@PostMapping("/saveSuppliers")   //Insert Data
	public List<Supplier> saveSuppliers(@RequestBody List<Supplier> suppliers){
		return supplierService.saveSuppliers(suppliers);
	}
	
	@GetMapping("/getAllSuppliers")   //Insert Data
	public List<Supplier> getAllSuppliers(){
		List<Supplier> suppliers= supplierService.getAllSuppliers();
		return suppliers;
	}
	
	@GetMapping("/getSingleSuppliers/{suppId}")   //Insert Data
	public Supplier getSingleSupplier(@PathVariable int suppId){
		Supplier supplier= supplierService.getSingleSupplier(suppId);
		return supplier;
	}
	
	@GetMapping("/getSupplierByCity/{suppCity}")   //Insert Data
	public List<Supplier> getSupplierByCity(@PathVariable String suppCity){
		List<Supplier> suppliers= supplierService.getSupplierByCity(suppCity);
		return suppliers;
	}
}

//Post - 	Insert
//Put - 	Update
//Delete -	Delete
//Get   - 	Select/Read

//RequestMapping - support all(Insert,Update,Delete,Select)
