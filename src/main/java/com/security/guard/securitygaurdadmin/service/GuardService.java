package com.security.guard.securitygaurdadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.security.guard.securitygaurdadmin.models.Guard;
import com.security.guard.securitygaurdadmin.repository.EmergencyContactRepository;
import com.security.guard.securitygaurdadmin.repository.GuardRepository;

@Service
public class GuardService {
	@Autowired
	GuardRepository guardRepository;

	@Autowired
	EmergencyContactRepository emergencyContactRepository;
	
	/*
	 * @Autowired SupervisorRepository supervisorRepository;
	 */	
	public Guard saveGuard(Guard guard) {
		return guardRepository.save(guard);
	}
	
	public Optional<Guard> findGuard(String contact) {
		return guardRepository.findByContact(contact);
	}

	public Optional<Guard> findGuard(long contact) {
		return guardRepository.findByTelegramId(contact);
	}


	public Page<Guard> getAllGuards(int page,int size) {
		return guardRepository.findAll(PageRequest.of(page, size));
	}
	
	public List<Guard> getAllGuards() {
		return guardRepository.findAll();
	}
	
	public List<Guard> getAllGuardsBySupervisor(long id) {
		return guardRepository.findBySupervisor(id);
	}
	
}
