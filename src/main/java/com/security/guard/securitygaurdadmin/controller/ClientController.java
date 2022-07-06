package com.security.guard.securitygaurdadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.Post;
import com.security.guard.securitygaurdadmin.models.PostManager;
import com.security.guard.securitygaurdadmin.models.PostManagerPost;
import com.security.guard.securitygaurdadmin.models.PostShiftSetting;
import com.security.guard.securitygaurdadmin.service.ClientService;

@RestController
@RequestMapping("/v1/api")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	
	@PostMapping("/client")
	public ResponseEntity<Client> saveClient(@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PutMapping("/client")
	public ResponseEntity<Client> update(@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);

		}
		
	}
	@PostMapping("/postmanager")
	public ResponseEntity<PostManager> saveClient(@RequestBody PostManager manager){
		try {
			return new ResponseEntity<PostManager>(clientService.saveManager(manager), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<PostManager>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PostMapping("/post")
	public ResponseEntity<Post> savePost(@RequestBody Post post){
		try {
			return new ResponseEntity<Post>(clientService.saveClientPost(post), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PostMapping("/post/manager/post")
	public ResponseEntity<List<PostManagerPost>> savePost(@RequestBody List<PostManagerPost> post){
		System.err.println(post.size());
		try {
			return new ResponseEntity<List<PostManagerPost>>(clientService.savePostManagerPost(post), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostManagerPost>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PostMapping("/post/shift/setting")
	public ResponseEntity<List<PostShiftSetting>> savePostSetting(@RequestBody List<PostShiftSetting> post){
		System.err.println(post.size());
		try {
			return new ResponseEntity<List<PostShiftSetting>>(clientService.saveSetting(post), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostShiftSetting>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	
	@GetMapping("/post/shift/setting")
	public ResponseEntity<List<PostShiftSetting>> savePostSetting(@RequestParam long postId){
	System.err.println("--------"+postId);
		try {
			return new ResponseEntity<List<PostShiftSetting>>(clientService.getSetting(postId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostShiftSetting>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/clients")
	public ResponseEntity<Page<Client>> getClients(@RequestParam int size,@RequestParam int page){
		try {
			return new ResponseEntity<Page<Client>>(clientService.getClients(page, size), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Page<Client>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/client/posts")
	public ResponseEntity<List<Post>> getClients(@RequestParam long clientId){
		try {
			return new ResponseEntity<List<Post>>(clientService.getPosts(clientId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Post>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getPosts(){
		try {
			return new ResponseEntity<List<Post>>(clientService.getPosts(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Post>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/post/managers")
	public ResponseEntity<List<PostManager>> getPostManagers(){
		try {
			return new ResponseEntity<List<PostManager>>(clientService.getManagers(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostManager>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/managers/by/post")
	public ResponseEntity<List<PostManager>> getClientPostManagers(@RequestParam long id){
		try {
			return new ResponseEntity<List<PostManager>>(clientService.getManagersByPost(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostManager>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/client/post/managers")
	public ResponseEntity<List<PostManager>> getPostClientManagers(@RequestParam long clientId){
		try {
			return new ResponseEntity<List<PostManager>>(clientService.getManagers(clientId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<PostManager>>(HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/clients/region")
	public ResponseEntity<Page<Client>> getClient(@RequestParam int size,@RequestParam int page,@RequestParam long regionId){
		
			return new ResponseEntity<Page<Client>>(clientService.getClients(page, size,regionId), HttpStatus.OK);
		
	}
	
	@GetMapping("/clients/all")
	public ResponseEntity<List<Client>> getClients(){
		
			return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
		
	}
	
	

	
	@SuppressWarnings("unchecked")
	@GetMapping("/clients/page")
	public ResponseEntity<Page<Client>> getClient(@RequestParam int size,@RequestParam int page){
		try {
			return new ResponseEntity<Page<Client>>(clientService.getClients(page, size), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Page<Client>>((Page<Client>) new Object(),HttpStatus.BAD_REQUEST);

		}
		
	}
}
