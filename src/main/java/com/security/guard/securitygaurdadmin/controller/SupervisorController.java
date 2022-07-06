package com.security.guard.securitygaurdadmin.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.guard.securitygaurdadmin.models.Guard;
import com.security.guard.securitygaurdadmin.models.Supervisor;
import com.security.guard.securitygaurdadmin.service.GuardService;
import com.security.guard.securitygaurdadmin.service.SupervisorService;


@RestController
@RequestMapping("/v1/api")
public class SupervisorController {
	@Autowired
	SupervisorService supervisorService;
	@Autowired
	GuardService guardService;
	

	@Value("${file.upload-dir}")
	String UPLOAD_FOLDER;
	@PostMapping("/supervisor")
	public ResponseEntity<Supervisor> saveSupervisor(@RequestBody Supervisor supervisor){
		supervisor.setDateAdded(LocalDateTime.now());
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(supervisor.getPicture());
			String fileName= System.currentTimeMillis()+supervisor.getFirstName();
			FileUtils.writeByteArrayToFile(new File(UPLOAD_FOLDER+fileName), decodedBytes);
			supervisor.setPicture(fileName);
			return new ResponseEntity<Supervisor>(supervisorService.saveSupervisor(supervisor), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Supervisor>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/supervisors")
	public ResponseEntity<Page<Supervisor>> saveSupervisor(@RequestParam int size,@RequestParam int page){
		
		try {
			return new ResponseEntity<Page<Supervisor>>(supervisorService.getSupervisors(size,page), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Page<Supervisor>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/supervisors/all")
	public ResponseEntity<List<Supervisor>> saveSupervisors(){
		
		try {
			return new ResponseEntity<List<Supervisor>>(supervisorService.getSupervisors(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Supervisor>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/supervisor/guards")
	public ResponseEntity<List<Guard>> getSupervisorGuards(@RequestParam long superId){
		
		try {
			return new ResponseEntity<List<Guard>>(guardService.getAllGuardsBySupervisor(superId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Guard>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping("/supervisor")
	public ResponseEntity<Supervisor> update(@RequestBody Supervisor supervisor){
		
		try {
			return new ResponseEntity<Supervisor>(supervisorService.saveSupervisor(supervisor), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Supervisor>(HttpStatus.BAD_REQUEST);

		}
	}

}
