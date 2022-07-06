package com.security.guard.securitygaurdadmin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.guard.securitygaurdadmin.models.Attendance;
import com.security.guard.securitygaurdadmin.repository.AttendanceRepository;

@Service
public class AttendanceService {
	@Autowired
	AttendanceRepository attendanceRepository;
	
	public Optional<Attendance> getStaffRecentAttendance(long id) {
		return attendanceRepository.findAttendanceByGuard(id);
	}
	
	public Attendance saveStaffAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}
	
}
