package com.security.guard.securitygaurdadmin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	
	@Query(value = "SELECT * FROM attendance WHERE guard_id=?1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
	Optional<Attendance> findAttendanceByGuard(long guardId);

}
