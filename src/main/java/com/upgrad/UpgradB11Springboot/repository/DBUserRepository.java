package com.upgrad.UpgradB11Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.UpgradB11Springboot.entity.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long>{
	
	DBUser findByUsername(String str);

}
