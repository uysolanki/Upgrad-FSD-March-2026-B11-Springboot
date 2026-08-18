package com.upgrad.UpgradB11Springboot.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SupplierDTO {

	private String supplierName;
	private String supplierEmail;
	private long supplierContactNumber;
	private boolean isCODAvailable;
	private LocalDate dateOfEstablisment;
	private String supplierCity;
	
	
}
