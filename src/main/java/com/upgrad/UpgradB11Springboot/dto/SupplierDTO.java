package com.upgrad.UpgradB11Springboot.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Supplier Name is required")
    @Size(min = 6, max = 100, message = "Supplier Name be between 6 and 100 characters") 
	private String supplierName;
    
    @Email(message = "Enter valid email address")
	private String supplierEmail;
    
     
    
   // @Pattern(regexp = "^[6-9]\\d{9}$", message = "Enter a valid 10-digit Indian mobile number")
    @Digits(integer = 10, fraction = 0, message = "Contact number must contain 10 digits")
    private long supplierContactNumber;
	
    @NotNull(message = "Please specify whether COD is available")
    private boolean isCODAvailable;
	
	@PastOrPresent(message = "Establishment date cannot be on the future")
	private LocalDate dateOfEstablisment;
	
	@NotBlank(message = "Supplier Name is required")
	private String supplierCity;
	
	
}
