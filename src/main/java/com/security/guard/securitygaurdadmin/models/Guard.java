package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Guard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String firstName;
	private String middleName;
	private String picture;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String contact;
	private long telegramId;
	private LocalDateTime dateAdded;
	private String email;
	private String address;
	private String dateEmployed;
	private int status;
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	@ManyToOne
	@JoinColumn(name="supervisor_id")
	private Supervisor supervisor;
	
	@Override
	public String toString() {
		return "Guard [lastName=" + lastName + ", firstName=" + firstName + ", dob=" + dob + ", email=" + email
				+ ", address=" + address + ", dateEmployed=" + dateEmployed + ", status=" + status + "]";
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "guard",cascade = CascadeType.PERSIST)
	List<EmergencyContact> emergencyContacts;
	
	@ManyToOne
	@JoinColumn(name="rank_id",updatable = true,insertable = true)
	private Rank rank;
	
	@OneToMany(mappedBy = "guard")
	private List<PostingGuard> postingGuard;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;


}
