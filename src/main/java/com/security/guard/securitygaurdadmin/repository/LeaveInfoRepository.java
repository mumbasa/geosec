package com.security.guard.securitygaurdadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.LeaveInfo;

@Repository
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo, Long> {

}
