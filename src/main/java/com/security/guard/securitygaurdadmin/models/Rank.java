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
public class Rank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "rank")
	private long id;
	private String rank;
	private int minimumHours;
	private int leaveDays;

}
