package com.security.guard.securitygaurdadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.Post;
import com.security.guard.securitygaurdadmin.models.PostManager;
import com.security.guard.securitygaurdadmin.models.PostManagerPost;
import com.security.guard.securitygaurdadmin.models.PostShiftSetting;
import com.security.guard.securitygaurdadmin.models.Region;
import com.security.guard.securitygaurdadmin.repository.ClientRepository;
import com.security.guard.securitygaurdadmin.repository.PostManagerPostRepository;
import com.security.guard.securitygaurdadmin.repository.PostManagerRepository;
import com.security.guard.securitygaurdadmin.repository.PostRepository;
import com.security.guard.securitygaurdadmin.repository.PostShiftSettingRepository;
import com.security.guard.securitygaurdadmin.repository.RegionRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	PostManagerRepository postManagerRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostManagerPostRepository postManagerPostRepository;
	
	@Autowired
	PostShiftSettingRepository postShiftSettingRepository;
	
	
	public Client saveClient(Client client) {
		client.setStatus(1);
		return clientRepository.save(client);
		
	}
	
	public Client deleteClient(Client client) {
		client.setStatus(0);
		client.getPosts().forEach(e ->e.setStatus(0));
		postRepository.saveAll(client.getPosts());
		return clientRepository.save(client);
		
	}
	

	public Client activateClient(Client client) {
		client.setStatus(1);
		client.getPosts().forEach(e ->e.setStatus(1));
		postRepository.saveAll(client.getPosts());
		return clientRepository.save(client);
		
	}
	
	public PostShiftSetting saveSetting(PostShiftSetting setting) {
		return postShiftSettingRepository.save(setting);
		
	}
	
	public List<PostShiftSetting> saveSetting(List<PostShiftSetting> setting) {
		System.err.println("-----");
		return postShiftSettingRepository.saveAll(setting);
		
	}
	
	public List<PostShiftSetting> getSetting(long postId) {
		System.err.println("-----"+postRepository.getById(postId).getBorder3());
		return postShiftSettingRepository.findByPost(postRepository.findById(postId).get());
		
	}
	
	
	public List<PostManagerPost> savePostManagerPost(List<PostManagerPost> client) {
		return postManagerPostRepository.saveAll(client);
		
	}
	public Post saveClientPost(Post clientPost) {
		return postRepository.save(clientPost);
		
	}
	
	public List<Post> getPosts(long client) {
		Client c = clientRepository.getById(client);
		System.err.println(c.toString()+"---------");
		return postRepository.findByClient(c);
		
	}
	
	public List<Post> getPosts() {
		return postRepository.findAll();
		
	}

	
	public List<PostManager> getManagers() {
		return postManagerRepository.findAll();
		
	}
	
	public List<PostManager> getManagers(long postId) {
		return postManagerRepository.findAll();
		
	}
	
	public List<PostManager> getManagersByPost(long id) {
		
		return postManagerRepository.findAllByPost(id);
		
	}
	
	public PostManager saveManager(PostManager client) {
		return postManagerRepository.save(client);
		
	}
	
	public Page<Client> getClients(int page,int size) {
		return clientRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public List<Client> getClients() {
		return clientRepository.findAll();
		
	}
	
	public Page<Client> getClients(int page,int size,long regionId) {
		System.err.println(" --------------"+regionId);
		Region region = regionRepository.findById(regionId).get();
		System.err.println(region.getRegion() +" --------------"+region.getId());
		Pageable pageableElements = PageRequest.of(page, size);
		return clientRepository.findByRegion(region,pageableElements);
		
	}
}
