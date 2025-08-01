package com.skillsync.skillsync_backend.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String achievementType; // e.g. FIRST_SESSION, MENTOR_STREAK

    private String title;

    @Lob
    private String description;

    private String badgeIcon;

    @Lob
    private String metadata; // JSON as String

    private LocalDateTime earnedAt;

    public Achievement() {
    }
    

    public Achievement(Long id, User user, String achievementType, String title, String description, String badgeIcon,
            String metadata, LocalDateTime earnedAt) {
        this.id = id;
        this.user = user;
        this.achievementType = achievementType;
        this.title = title;
        this.description = description;
        this.badgeIcon = badgeIcon;
        this.metadata = metadata;
        this.earnedAt = earnedAt;
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

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
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

    public String getBadgeIcon() {
        return badgeIcon;
    }

    public void setBadgeIcon(String badgeIcon) {
        this.badgeIcon = badgeIcon;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getEarnedAt() {
        return earnedAt;
    }

    public void setEarnedAt(LocalDateTime earnedAt) {
        this.earnedAt = earnedAt;
    }

    // Getters and Setters
    
}

