package com.upgrad.UpgradB11Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.upgrad.UpgradB11Springboot.entity.Supplier;
import com.upgrad.UpgradB11Springboot.exception.SupplierNotFoundException;
import com.upgrad.UpgradB11Springboot.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	SupplierRepository supplierRepository;

	public Supplier saveSupplier(Supplier s1) {
		return supplierRepository.save(s1);
	}

	public List<Supplier> saveSuppliers(List<Supplier> suppliers) {
		return supplierRepository.saveAll(suppliers);
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public Supplier getSingleSupplier(int suppId) {
		return supplierRepository.findById(suppId).get();
	}

	

	public List<Supplier> getSupplierByCity(String suppCity) {
		return supplierRepository.findBySupplierCity(suppCity);
	}

	public Page<Supplier> getAllSuppliersUsingPagination(int pageNumber,int pageSize) {
		return supplierRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public void deleteSupplierById(int suppId) throws SupplierNotFoundException
	{
		
		if(supplierRepository.existsById(suppId))
		{
		supplierRepository.deleteById(suppId);
		}
		else
		{
			throw new SupplierNotFoundException("Supplier with ID "+suppId +" does not exist");
		}
		
	}
}
