package com.skillsync.skillsync_backend.repository;

import com.skillsync.skillsync_backend.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

