package com.security.guard.securitygaurdadmin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Guard;

@Repository
public interface GuardRepository extends JpaRepository<Guard, Long> {

	//Page<Guard> findBySupervisor(Pageable pageable);
	@Query(value = "SELECT * FROM guard WHERE supervisor_id= ?1",nativeQuery = true)
	List<Guard> findBySupervisor(long id);
	Optional<Guard> findByTelegramId(long contact);
	Optional<Guard> findByContact(String contact);
}
