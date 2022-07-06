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
public class LeaveInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "leave")
	private long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDateTime dateAdded;
	private int days;
	@ManyToOne
	@JoinColumn(name="guard_id",updatable = true,insertable = true)
	private Guard guard;
}
