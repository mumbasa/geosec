package com.security.guard.securitygaurdadmin.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class PostShiftSetting {
	@Id
	@GeneratedValue(generator = "postshiftsetting", strategy = GenerationType.IDENTITY)
	private long id;
	private int numberofGuards;
	@ManyToOne
	@JoinColumn(name = "shift_id")
	private Shift shift;

    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
    private int status;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "postShiftSetting")
	private List<PostingGuard>
	  postingGuard;
	 
}
