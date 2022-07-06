package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table
@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "branch")
	private long id;
	private String branch;
	private LocalDate dateAdded;
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	

}
