package com.skillsync.skillsync_backend.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_skills")
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillType skillType; // OFFERING, LEARNING

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProficiencyLevel proficiencyLevel;

    private Integer yearsExperience;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserSkill() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UserSkill(User user, Skill skill, SkillType skillType, ProficiencyLevel proficiencyLevel,
                     Integer yearsExperience, String description) {
        this.user = user;
        this.skill = skill;
        this.skillType = skillType;
        this.proficiencyLevel = proficiencyLevel;
        this.yearsExperience = yearsExperience;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ========== Getters and Setters ==========

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Skill getSkill() { return skill; }

    public void setSkill(Skill skill) { this.skill = skill; }

    public SkillType getSkillType() { return skillType; }

    public void setSkillType(SkillType skillType) { this.skillType = skillType; }

    public ProficiencyLevel getProficiencyLevel() { return proficiencyLevel; }

    public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) { this.proficiencyLevel = proficiencyLevel; }

    public Integer getYearsExperience() { return yearsExperience; }

    public void setYearsExperience(Integer yearsExperience) { this.yearsExperience = yearsExperience; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // ========== ENUMS ==========

    public enum SkillType {
        OFFERING,
        LEARNING
    }

    public enum ProficiencyLevel {
        NOVICE,
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }
}

