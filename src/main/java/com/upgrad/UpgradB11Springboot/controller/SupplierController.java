//package com.upgrad.UpgradB11Springboot.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.upgrad.UpgradB11Springboot.dto.SupplierDTO;
//import com.upgrad.UpgradB11Springboot.entity.Supplier;
//import com.upgrad.UpgradB11Springboot.exception.SupplierNotFoundException;
//import com.upgrad.UpgradB11Springboot.service.SupplierService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/supplier")
//public class SupplierController 
//{
//	@Autowired
//	SupplierService supplierService;
//	
//	@PostMapping("/saveSupplier")   //Insert Data							//C
//	public Supplier saveSupplier(@RequestBody Supplier s1){
//		return supplierService.saveSupplier(s1);
//	}
//	
//	@PostMapping("/saveSupplierUsingDTO")   //Insert Data							//C
//	public SupplierDTO saveSupplier(@Valid @RequestBody SupplierDTO supplierDTO){
//		return supplierService.saveSupplierUsingDTO(supplierDTO);
//	}
//	
//	@PostMapping("/saveSuppliers")   //Insert Data
//	public List<Supplier> saveSuppliers(@RequestBody List<Supplier> suppliers){
//		return supplierService.saveSuppliers(suppliers);
//	}
//	
//	@GetMapping("/getAllSuppliers")   //Insert Data
//	public List<Supplier> getAllSuppliers(){
//		List<Supplier> suppliers= supplierService.getAllSuppliers();
//		return suppliers;
//	}
//	
//	@GetMapping("/getSingleSuppliers/{suppId}")   //Insert Data				//R
//	public Supplier getSingleSupplier(@PathVariable int suppId){
//		Supplier supplier= supplierService.getSingleSupplier(suppId);
//		return supplier;
//	}
//	
//	@GetMapping("/getSupplierByCity/{suppCity}")   //Insert Data
//	public List<Supplier> getSupplierByCity(@PathVariable String suppCity){
//		List<Supplier> suppliers= supplierService.getSupplierByCity(suppCity);
//		return suppliers;
//	}
//	
//	
//	@GetMapping("/getAllSuppliersUsingPagination/{pageNumber}/{pageSize}")   //Insert Data
//	public Page<Supplier> getAllSuppliersUsingPagination(@PathVariable int pageNumber,@PathVariable int pageSize){
//		Page<Supplier> suppliers= supplierService.getAllSuppliersUsingPagination(pageNumber,pageSize);
//		return suppliers;
//	}
//	
//	@DeleteMapping("/deleteSupplierById/{suppId}")							//D
//	public String deleteSupplierById(@PathVariable int suppId)
//	{
//		try
//		{
//		supplierService.deleteSupplierById(suppId);
//		return "Supplier Deleted with ID "+suppId;
//		}
//		catch(SupplierNotFoundException ex)
//		{
//			return ex.getMessage();
//		}
//	}
//	
//	
//	@PutMapping("/updateSupplier/{suppId}")										//U
//	public String updateSupplier(@PathVariable int suppId, @RequestBody Supplier newValues)
//	{
//		try
//		{
//		supplierService.updateSupplier(suppId,newValues);
//		return "Supplier Updated with ID "+suppId;
//		}
//		catch(SupplierNotFoundException ex)
//		{
//			return ex.getMessage();
//		}
//	}
//	
//	@PutMapping("/updateSupplierusingGEH/{suppId}")										//U
//	public String updateSupplierusingGEH(@PathVariable int suppId, @RequestBody Supplier newValues)
//	{
//		supplierService.updateSupplier(suppId,newValues);
//		return "Supplier Updated with ID "+suppId;
//	}
//}
//
////Post - 	Insert
////Put - 	Update
////Delete -	Delete
////Get   - 	Select/Read
//
////RequestMapping - support all(Insert,Update,Delete,Select)
