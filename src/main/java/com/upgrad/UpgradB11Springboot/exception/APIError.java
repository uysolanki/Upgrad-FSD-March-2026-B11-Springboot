package com.upgrad.UpgradB11Springboot.exception;

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
public class APIError {

	private String field;
	private Object rejectedValue;
	private String defaultMessage;
	
}
