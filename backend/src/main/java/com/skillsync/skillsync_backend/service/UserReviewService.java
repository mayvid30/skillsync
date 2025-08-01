package com.skillsync.skillsync_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.UserReview;
import com.skillsync.skillsync_backend.repository.UserReviewRepository;

@Service
public class UserReviewService {

    @Autowired
    private UserReviewRepository repository;

    public List<UserReview> getByRevieweeId(Long revieweeId) {
        return repository.findByRevieweeId(revieweeId);
    }

    public List<UserReview> getByReviewerId(Long reviewerId) {
        return repository.findByReviewerId(reviewerId);
    }

    public UserReview getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserReview create(UserReview review) {
        review.setCreatedAt(LocalDateTime.now());
        return repository.save(review);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

