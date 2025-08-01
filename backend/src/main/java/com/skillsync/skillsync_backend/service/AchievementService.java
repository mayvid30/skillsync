package com.skillsync.skillsync_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.Achievement;
import com.skillsync.skillsync_backend.repository.AchievementRepository;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository repository;

    public List<Achievement> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Achievement getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Achievement create(Achievement achievement) {
        achievement.setEarnedAt(LocalDateTime.now());
        return repository.save(achievement);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

