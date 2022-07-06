package com.security.guard.securitygaurdadmin.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table
@Entity
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "shift")
	private long id;
	private String shift;

	private String startTime;
	private String endTime;
	private int hours;
	
}
