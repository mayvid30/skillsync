package com.skillsync.skillsync_backend.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;

    @Lob
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType type; // SESSION_REMINDER, CONNECTION_REQUEST, etc.

    @Enumerated(EnumType.STRING)
    private PriorityLevel priority; // LOW, MEDIUM, HIGH

    @Lob
    private String data; // JSON string (optional parsing)

    private boolean isRead;

    private LocalDateTime readAt;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    
    public Notification() {
    }

    
    public Notification(Long id, User user, String title, String message, NotificationType type, PriorityLevel priority,
            String data, boolean isRead, LocalDateTime readAt, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.message = message;
        this.type = type;
        this.priority = priority;
        this.data = data;
        this.isRead = isRead;
        this.readAt = readAt;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public NotificationType getType() {
        return type;
    }
    public void setType(NotificationType type) {
        this.type = type;
    }
    public PriorityLevel getPriority() {
        return priority;
    }
    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public boolean isRead() {
        return isRead;
    }
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
    public LocalDateTime getReadAt() {
        return readAt;
    }
    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    // Getters & Setters
    //enum
    public enum NotificationType {
    SESSION_REMINDER,
    CONNECTION_REQUEST,
    ACHIEVEMENT,
    SYSTEM
     }

     public enum PriorityLevel {
    LOW,
    MEDIUM,
    HIGH
     }


}

