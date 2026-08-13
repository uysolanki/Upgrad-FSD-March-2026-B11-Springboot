package com.upgrad.UpgradB11Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.UpgradB11Springboot.entity.Supplier;
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
}
