package com.security.guard.securitygaurdadmin.models;

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

@Getter
@Setter
@Table
@Entity
public class Posting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "posting")
	private long id;
	private LocalDateTime shiftDate;
	private LocalDateTime dateAdded;
	@ManyToOne
	@JoinColumn(name = "post_shift_setting_id", insertable = true, nullable = false)
	private PostShiftSetting postShiftSetting;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "guard_id",insertable = false,nullable = false) private
	 * List<Guard> guards;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name="post_id") private Post post;
	 */

}
