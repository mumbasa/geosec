package com.security.guard.securitygaurdadmin.models;

import java.sql.Time;
import java.time.LocalDate;

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

@Table
@Entity
@Getter
@Setter
public class PostingGuard {
	@Id
	@GeneratedValue(generator = "postingGuard", strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "guard_id")
	private Guard guard;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "post_shift_setting_id")
	private PostShiftSetting postShiftSetting;
	private Time time;
	

}
