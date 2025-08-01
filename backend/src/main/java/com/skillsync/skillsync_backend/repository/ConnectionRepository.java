package com.skillsync.skillsync_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsync.skillsync_backend.model.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {}
