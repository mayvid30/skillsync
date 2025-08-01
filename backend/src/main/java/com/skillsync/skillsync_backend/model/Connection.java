package com.skillsync.skillsync_backend.model;

import java.time.LocalDateTime;


import jakarta.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "mentor_id")
    private User mentor;

    @ManyToOne @JoinColumn(name = "learner_id")
    private User learner;

    @ManyToOne @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(columnDefinition = "TEXT")
    private String initialMessage;

    @Column(columnDefinition = "TEXT")
    private String learningObjectives;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer maxSessions;

    @Column(columnDefinition = "TEXT")
    private String mentorNotes;

    @Column(columnDefinition = "TEXT")
    private String learnerNotes;

    private LocalDateTime createdAt;
    private LocalDateTime acceptedAt;
    private LocalDateTime completedAt;

    public enum Status {
        PENDING, ACTIVE, COMPLETED, CANCELLED
    }

    public Connection(Long id, User mentor, User learner, Skill skill, String initialMessage, String learningObjectives,
            Status status, Integer maxSessions, String mentorNotes, String learnerNotes, LocalDateTime createdAt,
            LocalDateTime acceptedAt, LocalDateTime completedAt) {
        this.id = id;
        this.mentor = mentor;
        this.learner = learner;
        this.skill = skill;
        this.initialMessage = initialMessage;
        this.learningObjectives = learningObjectives;
        this.status = status;
        this.maxSessions = maxSessions;
        this.mentorNotes = mentorNotes;
        this.learnerNotes = learnerNotes;
        this.createdAt = createdAt;
        this.acceptedAt = acceptedAt;
        this.completedAt = completedAt;
    }

    public Connection() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public User getLearner() {
        return learner;
    }

    public void setLearner(User learner) {
        this.learner = learner;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getInitialMessage() {
        return initialMessage;
    }

    public void setInitialMessage(String initialMessage) {
        this.initialMessage = initialMessage;
    }

    public String getLearningObjectives() {
        return learningObjectives;
    }

    public void setLearningObjectives(String learningObjectives) {
        this.learningObjectives = learningObjectives;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getMaxSessions() {
        return maxSessions;
    }

    public void setMaxSessions(Integer maxSessions) {
        this.maxSessions = maxSessions;
    }

    public String getMentorNotes() {
        return mentorNotes;
    }

    public void setMentorNotes(String mentorNotes) {
        this.mentorNotes = mentorNotes;
    }

    public String getLearnerNotes() {
        return learnerNotes;
    }

    public void setLearnerNotes(String learnerNotes) {
        this.learnerNotes = learnerNotes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(LocalDateTime acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    
    
}
