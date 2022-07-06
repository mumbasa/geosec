package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDateTime;

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
public class Supervisor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String picture;
	private String dob;
	private String contact;
	private String telegramId;
	private LocalDateTime dateAdded;
	private String email;
	private String address;
	private String dateEmployed;
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;

}
