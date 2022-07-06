package com.security.guard.securitygaurdadmin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class PostManagerPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@ManyToOne
	@JoinColumn(name = "post_manager_id")
	private PostManager postManager;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
}
