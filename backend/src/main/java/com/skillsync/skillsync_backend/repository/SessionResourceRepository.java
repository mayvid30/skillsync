package com.skillsync.skillsync_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsync.skillsync_backend.model.SessionResource;

public interface SessionResourceRepository extends JpaRepository<SessionResource, Long> {
    List<SessionResource> findBySessionId(Long sessionId);
}

