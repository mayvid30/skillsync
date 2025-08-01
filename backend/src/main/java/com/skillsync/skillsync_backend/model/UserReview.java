package com.skillsync.skillsync_backend.model;

import jakarta.persistence.Lob;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "user_reviews")
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewee_id", nullable = false)
    private User reviewee;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    private int rating; // 1 to 5

    @Lob
    private String comment;

    @Lob
    private String tags; // JSON array of tags

    private boolean isPublic;

    private LocalDateTime createdAt;

    public UserReview() {
    }

    public UserReview(Long id, User reviewer, User reviewee, Session session, int rating, String comment, String tags,
            boolean isPublic, LocalDateTime createdAt) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewee = reviewee;
        this.session = session;
        this.rating = rating;
        this.comment = comment;
        this.tags = tags;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public User getReviewee() {
        return reviewee;
    }

    public void setReviewee(User reviewee) {
        this.reviewee = reviewee;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters and Setters
    
}

