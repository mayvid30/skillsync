package com.skillsync.skillsync_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsync.skillsync_backend.model.UserAvailability;

public interface UserAvailabilityRepository extends JpaRepository<UserAvailability, Long> {
    List<UserAvailability> findByUserId(Long userId);
    List<UserAvailability> findByUserIdAndIsActiveTrue(Long userId);
}

