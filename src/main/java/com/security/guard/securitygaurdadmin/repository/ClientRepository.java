package com.security.guard.securitygaurdadmin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.Region;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	Page<Client> findByRegion(Region region,Pageable pageable);

}
