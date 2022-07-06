package com.security.guard.securitygaurdadmin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "region")
	private long id;
	private String region;
}
