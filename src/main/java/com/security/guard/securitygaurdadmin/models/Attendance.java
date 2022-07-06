package com.security.guard.securitygaurdadmin.models;

import java.time.LocalDate;
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
@Entity
@Table
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "attendance")
	private long id;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;
	@ManyToOne
	@JoinColumn(name="guard_id",nullable = false)
	private Guard guard;
	private String statusIn;
	private String statusOut;
	private int timeWorkedInMinutes;
	private int minutesLate;
	private int deficit;
	private LocalDate dateRecorded;
	private String location;
	
	

}
