package com.upgrad.UpgradB11Springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.UpgradB11Springboot.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>
{
	public List<Supplier> findBySupplierCity(String s);
}
