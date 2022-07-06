package com.security.guard.securitygaurdadmin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
	Optional<Branch> findByBranch(String branch);

}
