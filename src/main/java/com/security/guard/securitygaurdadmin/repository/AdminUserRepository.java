package com.security.guard.securitygaurdadmin.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	Optional<AdminUser> findByUsername(String username);
	
}
