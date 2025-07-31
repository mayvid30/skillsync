package com.skillsync.skillsync_backend.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "session_assignments")
public class SessionAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime dueDate;
    private boolean isCompleted;

    @Column(columnDefinition = "TEXT")
    private String learnerSubmission;

    private String mentorFeedback;

    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public enum Type {
        HOMEWORK, READING, PRACTICE, PROJECT
    }

    public SessionAssignment() {
    }

    public SessionAssignment(Long id, Session session, String title, String description, String instructions, Type type,
            LocalDateTime dueDate, boolean isCompleted, String learnerSubmission, String mentorFeedback,
            LocalDateTime createdAt, LocalDateTime completedAt) {
        this.id = id;
        this.session = session;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.type = type;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.learnerSubmission = learnerSubmission;
        this.mentorFeedback = mentorFeedback;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getLearnerSubmission() {
        return learnerSubmission;
    }

    public void setLearnerSubmission(String learnerSubmission) {
        this.learnerSubmission = learnerSubmission;
    }

    public String getMentorFeedback() {
        return mentorFeedback;
    }

    public void setMentorFeedback(String mentorFeedback) {
        this.mentorFeedback = mentorFeedback;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    
}
