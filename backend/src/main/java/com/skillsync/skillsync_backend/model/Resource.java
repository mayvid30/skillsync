package com.skillsync.skillsync_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by_user_id", nullable = false)
    private Long createdByUserId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    private String url;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "json")
    private String skillTags;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    private Integer viewsCount;
    private Integer likesCount;
    private Boolean isPublic;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum ResourceType {
        VIDEO, ARTICLE, PDF, LINK, EXERCISE
    }

    public enum DifficultyLevel {
        BEGINNER, INTERMEDIATE, ADVANCED
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCreatedByUserId() { return createdByUserId; }

    public void setCreatedByUserId(Long createdByUserId) { this.createdByUserId = createdByUserId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public ResourceType getResourceType() { return resourceType; }

    public void setResourceType(ResourceType resourceType) { this.resourceType = resourceType; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getSkillTags() { return skillTags; }

    public void setSkillTags(String skillTags) { this.skillTags = skillTags; }

    public DifficultyLevel getDifficultyLevel() { return difficultyLevel; }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public Integer getViewsCount() { return viewsCount; }

    public void setViewsCount(Integer viewsCount) { this.viewsCount = viewsCount; }

    public Integer getLikesCount() { return likesCount; }

    public void setLikesCount(Integer likesCount) { this.likesCount = likesCount; }

    public Boolean getIsPublic() { return isPublic; }

    public void setIsPublic(Boolean isPublic) { this.isPublic = isPublic; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

