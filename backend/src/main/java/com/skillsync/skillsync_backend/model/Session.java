package com.skillsync.skillsync_backend.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "connection_id")
    private Connection connection;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime scheduledTime;
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String meetingLink;
    private String agenda;

    @Column(columnDefinition = "TEXT")
    private String sessionNotes;

    @Column(columnDefinition = "TEXT")
    private String sessionSummary;

    private Integer mentorRating;
    private Integer learnerRating;

    private String mentorFeedback;
    private String learnerFeedback;

    private LocalDateTime createdAt;
    private LocalDateTime completedAt;


    
    public Session(Long id, Connection connection, String title, String description, LocalDateTime scheduledTime,
            Integer durationMinutes, Status status, String meetingLink, String agenda, String sessionNotes,
            String sessionSummary, Integer mentorRating, Integer learnerRating, String mentorFeedback,
            String learnerFeedback, LocalDateTime createdAt, LocalDateTime completedAt) {
        this.id = id;
        this.connection = connection;
        this.title = title;
        this.description = description;
        this.scheduledTime = scheduledTime;
        this.durationMinutes = durationMinutes;
        this.status = status;
        this.meetingLink = meetingLink;
        this.agenda = agenda;
        this.sessionNotes = sessionNotes;
        this.sessionSummary = sessionSummary;
        this.mentorRating = mentorRating;
        this.learnerRating = learnerRating;
        this.mentorFeedback = mentorFeedback;
        this.learnerFeedback = learnerFeedback;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public Session() {
    }

    public enum Status {
        SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
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

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public void setSessionNotes(String sessionNotes) {
        this.sessionNotes = sessionNotes;
    }

    public String getSessionSummary() {
        return sessionSummary;
    }

    public void setSessionSummary(String sessionSummary) {
        this.sessionSummary = sessionSummary;
    }

    public Integer getMentorRating() {
        return mentorRating;
    }

    public void setMentorRating(Integer mentorRating) {
        this.mentorRating = mentorRating;
    }

    public Integer getLearnerRating() {
        return learnerRating;
    }

    public void setLearnerRating(Integer learnerRating) {
        this.learnerRating = learnerRating;
    }

    public String getMentorFeedback() {
        return mentorFeedback;
    }

    public void setMentorFeedback(String mentorFeedback) {
        this.mentorFeedback = mentorFeedback;
    }

    public String getLearnerFeedback() {
        return learnerFeedback;
    }

    public void setLearnerFeedback(String learnerFeedback) {
        this.learnerFeedback = learnerFeedback;
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

