package com.security.guard.securitygaurdadmin.models;

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

@Setter
@Getter
@Table
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String postName;
	private String border1;
	private String border2;
	private String border3;
	private String border4;
	private int status;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "client_id", updatable = false, nullable = false, insertable = true)
	private Client client;

	
}
