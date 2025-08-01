
package com.skillsync.skillsync_backend.service;

import com.skillsync.skillsync_backend.model.LearningGoal;
import com.skillsync.skillsync_backend.repository.LearningGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningGoalService {

    @Autowired
    private LearningGoalRepository repository;

    public LearningGoal createGoal(LearningGoal goal) {
        goal.setCreatedAt(java.time.LocalDateTime.now());
        return repository.save(goal);
    }

    public List<LearningGoal> getAllGoals() {
        return repository.findAll();
    }

    public Optional<LearningGoal> getGoalById(Long id) {
        return repository.findById(id);
    }

    public void deleteGoal(Long id) {
        repository.deleteById(id);
    }

    public List<LearningGoal> getGoalsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
