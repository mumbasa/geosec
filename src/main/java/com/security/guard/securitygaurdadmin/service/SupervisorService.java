package com.security.guard.securitygaurdadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.security.guard.securitygaurdadmin.models.Supervisor;
import com.security.guard.securitygaurdadmin.repository.SupervisorRepository;

@Service
public class SupervisorService {

	@Autowired
	SupervisorRepository supervisorRepository;
	
	
	public Supervisor saveSupervisor(Supervisor superior) {
		return supervisorRepository.save(superior);
		
	}
	
	public Page<Supervisor> getSupervisors(int size,int page) {
		return supervisorRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public List<Supervisor> getSupervisors() {
		return supervisorRepository.findAll();
		
	}
	
	
}
