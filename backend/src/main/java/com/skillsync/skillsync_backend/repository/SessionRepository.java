package com.skillsync.skillsync_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsync.skillsync_backend.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {}