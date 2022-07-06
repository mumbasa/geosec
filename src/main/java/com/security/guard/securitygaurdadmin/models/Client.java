package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String contact;
	private String telegramId;
	private LocalDateTime dateAdded;
	private String email;
	private String address;
	private String picture;
	private int status;
	@ManyToOne
	@JoinColumn(name="region_id",updatable = false,insertable = true)
	private Region region;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Post> posts;

	@JsonManagedReference
	@OneToMany(mappedBy="client")
	private List<PostManager> managers;

	@Override
	public String toString() {
		return "Client [name=" + name + ", contact=" + contact + ", email=" + email + ", address=" + address + "]";
	}

}
