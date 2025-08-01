package com.skillsync.skillsync_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.UserAvailability;
import com.skillsync.skillsync_backend.repository.UserAvailabilityRepository;

@Service
public class UserAvailabilityService {

    @Autowired
    private UserAvailabilityRepository repository;

    public List<UserAvailability> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<UserAvailability> getActiveByUserId(Long userId) {
        return repository.findByUserIdAndIsActiveTrue(userId);
    }

    // public com.skillsync.skillsync_backend.controller.UserAvailability getById(Long id) {
    //     return repository.findById(id).orElse(null);
    // }

    // public UserAvailability create(com.skillsync.skillsync_backend.controller.UserAvailability availability) {
    //     availability.setCreatedAt(LocalDateTime.now());
    //     availability.setCreatedAt(LocalDateTime.now());
    //     return repository.saveAll(availability);
    // }

    // public UserAvailability update(Long id, com.skillsync.skillsync_backend.controller.UserAvailability updated) {
    //     UserAvailability existing = getByUserId(id);
    //     if (existing == null) return null;

    //     existing.setDayOfWeek(updated.getDayOfWeek());
    //     existing.setStartTime(updated.getStartTime());
    //     existing.setEndTime(updated.getEndTime());
    //     existing.setActive(updated.isActive());
    //     existing.setUpdatedAt(LocalDateTime.now());

    //     return repository.save(existing);
    // }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

