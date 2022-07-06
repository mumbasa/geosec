package com.security.guard.securitygaurdadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.PostManager;

@Repository
public interface PostManagerRepository extends JpaRepository<PostManager, Long> {
List<PostManager> findByClient(Client client);


@Query(value = " SELECT * FROM post_manager where id IN (SELECT post_manager_id from post_manager_post where post_id=?1)", nativeQuery = true)
List<PostManager> findAllByPost(long postId);
}
