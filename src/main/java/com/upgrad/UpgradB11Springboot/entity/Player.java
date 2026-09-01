package com.upgrad.UpgradB11Springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Player {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pno;
	private String pname;
	private int mp,rs;	
}
