package com.skillsync.skillsync_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsync.skillsync_backend.model.UserReview;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    List<UserReview> findByRevieweeId(Long revieweeId);
    List<UserReview> findByReviewerId(Long reviewerId);
}

