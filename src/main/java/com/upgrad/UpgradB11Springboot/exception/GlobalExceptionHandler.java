package com.upgrad.UpgradB11Springboot.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>> handleValidationExceptions(MethodArgumentNotValidException ex) 
	{
	 	List<APIError> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) 
		{
		APIError apiError = new APIError(error.getField(), error.getRejectedValue(),error.getDefaultMessage());
		errors.add(apiError);
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SupplierNotFoundException.class)
	public String handleSupplierNotFoundException(SupplierNotFoundException ex) 
	{
		return ex.getMessage();
	}
}
