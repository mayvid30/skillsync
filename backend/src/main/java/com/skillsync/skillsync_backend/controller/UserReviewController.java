package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsync.skillsync_backend.model.UserReview;
import com.skillsync.skillsync_backend.service.UserReviewService;

@RestController
@RequestMapping("/api/reviews")
public class UserReviewController {

    @Autowired
    private UserReviewService service;

    @GetMapping("/reviewee/{userId}")
    public ResponseEntity<List<UserReview>> getByReviewee(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByRevieweeId(userId));
    }

    @GetMapping("/reviewer/{userId}")
    public ResponseEntity<List<UserReview>> getByReviewer(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByReviewerId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReview> getById(@PathVariable Long id) {
        UserReview review = service.getById(id);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserReview> create(@RequestBody UserReview review) {
        return ResponseEntity.ok(service.create(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

