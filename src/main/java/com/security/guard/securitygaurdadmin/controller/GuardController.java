package com.security.guard.securitygaurdadmin.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.guard.securitygaurdadmin.helpers.Utilities;
import com.security.guard.securitygaurdadmin.models.Guard;
import com.security.guard.securitygaurdadmin.service.GuardService;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class GuardController {

	@Autowired
	GuardService guardService;

	@Value("${file.upload-dir}")
	String UPLOAD_FOLDER;
	
	@Autowired
	Utilities utilities;

	@PostMapping("/guard")
	public ResponseEntity<Guard> saveGuard(@RequestBody Guard guard) {
		guard.setDateAdded(LocalDateTime.now());
		try {
			utilities.getSimImage(guard);
			return new ResponseEntity<Guard>(guardService.saveGuard(guard), HttpStatus.OK);
		} catch (Exception e) 
		// TODO: handle exception

		{	e.printStackTrace();
			return new ResponseEntity<Guard>(HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/guard")
	public ResponseEntity<Guard> update(@RequestBody Guard guard) {
		try {
			return new ResponseEntity<Guard>(guardService.saveGuard(guard), HttpStatus.OK);
		} catch (Exception e)
		// TODO: handle exception
		{
			return new ResponseEntity<Guard>(HttpStatus.BAD_REQUEST);

		}
	}
	
	

	@GetMapping("/guards")
	public ResponseEntity<Page<Guard>> update(@RequestParam int page, @RequestParam int size) {
		try {
			return new ResponseEntity<Page<Guard>>(guardService.getAllGuards(page, size), HttpStatus.OK);
		} catch (Exception e)
		// TODO: handle exception
		{
			return new ResponseEntity<Page<Guard>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@GetMapping("/guard")
	public ResponseEntity<Guard> getGuard(@RequestParam long id) {
		System.err.println("finding guard");
		try {
			return new ResponseEntity<Guard>(guardService.findGuardById(id).get(), HttpStatus.OK);
		} catch (Exception e)
		// TODO: handle exception
		{
			return new ResponseEntity<Guard>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/guards/all")
	public ResponseEntity<List<Guard>> getall() {
	
			return new ResponseEntity<List<Guard>>(guardService.getAllGuards(), HttpStatus.OK);
	}
}
