package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsync.skillsync_backend.model.Achievement;
import com.skillsync.skillsync_backend.service.AchievementService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    @Autowired
    private AchievementService service;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Achievement>> getUserAchievements(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Achievement> getById(@PathVariable Long id) {
        Achievement achievement = service.getById(id);
        return achievement != null ? ResponseEntity.ok(achievement) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Achievement> create(@RequestBody Achievement achievement) {
        return ResponseEntity.ok(service.create(achievement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

