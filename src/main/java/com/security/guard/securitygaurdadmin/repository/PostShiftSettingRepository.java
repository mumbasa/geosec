package com.security.guard.securitygaurdadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.guard.securitygaurdadmin.models.Post;
import com.security.guard.securitygaurdadmin.models.PostShiftSetting;

@Repository
public interface PostShiftSettingRepository extends JpaRepository<PostShiftSetting, Long> {
List<PostShiftSetting> findByPost(Post post);
}
