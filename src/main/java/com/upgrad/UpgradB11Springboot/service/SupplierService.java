package com.upgrad.UpgradB11Springboot.service;

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
}
