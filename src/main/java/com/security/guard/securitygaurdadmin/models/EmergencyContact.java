package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class EmergencyContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "emergencyContact")
	private long id;
	private String name;
	private String contact;
	private LocalDateTime dateAdded;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="guard_id")
	private Guard guard;
}
