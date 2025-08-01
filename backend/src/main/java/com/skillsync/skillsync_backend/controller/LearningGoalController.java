
package com.skillsync.skillsync_backend.controller;

import com.skillsync.skillsync_backend.model.LearningGoal;
import com.skillsync.skillsync_backend.service.LearningGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class LearningGoalController {

    @Autowired
    private LearningGoalService goalService;

    @PostMapping
    public ResponseEntity<LearningGoal> create(@RequestBody LearningGoal goal) {
        return ResponseEntity.ok(goalService.createGoal(goal));
    }

    @GetMapping
    public List<LearningGoal> getAll() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningGoal> getById(@PathVariable Long id) {
        return goalService.getGoalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<LearningGoal> getByUser(@PathVariable Long userId) {
        return goalService.getGoalsByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
