package com.security.guard.securitygaurdadmin.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.guard.securitygaurdadmin.models.AdminUser;
import com.security.guard.securitygaurdadmin.models.ResponseMessage;
import com.security.guard.securitygaurdadmin.service.AdminUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/v1/api")
public class AdminUserController {
	@Autowired
	AdminUserService userService;

	@Value("${file.upload-dir}")
	String UPLOAD_FOLDER;

	@Value("${jwt.secret}")
	private String secret;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello, World";
	}

	@PostMapping("/adminuser")
	public ResponseEntity<AdminUser> saveUser(@RequestBody AdminUser user) {
		try {
		byte[] decodedBytes = Base64.getDecoder().decode(user.getPicture());
		String fileName = System.currentTimeMillis() + user.getName();
		FileUtils.writeByteArrayToFile(new File(UPLOAD_FOLDER + fileName), decodedBytes);
		user.setPicture(fileName);
		return new ResponseEntity<AdminUser>(userService.saveUser(user), HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<AdminUser>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/adminusers")
	public ResponseEntity<List<AdminUser>> adminUsers() {
		return new ResponseEntity<List<AdminUser>>(userService.getAllUsers(), HttpStatus.OK);

	}

	@PostMapping("/authenticated")
	public ResponseEntity<ResponseMessage> login(@RequestBody AdminUser user) {
		ResponseMessage message = new ResponseMessage();

		Optional<AdminUser> details = userService.loadUserByUsernames(user.getUsername());
		if (details.isPresent()) {
			System.err.println("------------------" + details.toString());

			String token = Jwts.builder().setSubject(details.get().getName())
					.claim("authorities", details.get().getAuthorities()).setIssuedAt(new Date())
					.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
					.signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
			details.get().setToken(token);
			message.setPayload(details.get());
			message.setMessage("User found Successfully");
			message.setStatusCode(200);
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
		} else {
			// TODO:ser handle exception
			message.setStatusCode(500);
			message.setMessage("Wrong credentials");
			return new ResponseEntity<ResponseMessage>(message,HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AdminUser> logins(@RequestBody AdminUser user) {
		ResponseMessage message = new ResponseMessage();

		Optional<AdminUser> details = userService.loadUserByUsernames(user.getUsername());
		if (details.isPresent()) {
			System.err.println("------------------" + details.toString());

			String token = Jwts.builder().setSubject(details.get().getName())
					.claim("authorities", details.get().getAuthorities()).setIssuedAt(new Date())
					.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
					.signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
			details.get().setToken(token);
			message.setPayload(details.get());
			message.setMessage("User found Successfully");
			message.setStatusCode(200);
			return new ResponseEntity<AdminUser>(details.get(), HttpStatus.OK);
		} else {
			// TODO:ser handle exception
			message.setStatusCode(500);
			message.setMessage("Wrong credentials");
			return new ResponseEntity<AdminUser>(HttpStatus.BAD_REQUEST);
		}

	}


}
