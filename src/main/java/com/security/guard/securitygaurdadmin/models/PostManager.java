package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDateTime;
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
public class PostManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "postmanager")
	private long id;
	private String name;
	private String contact;
	private String telegramId;
	private LocalDateTime dateAdded;
	private String email;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
//JsonBackReference
	/*
	 * @OneToMany(mappedBy = "postManager") List<PostManagerPost> managerPosts;
	 */
}
