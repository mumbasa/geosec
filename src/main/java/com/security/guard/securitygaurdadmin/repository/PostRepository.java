package com.security.guard.securitygaurdadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByClient(Client client);
}
