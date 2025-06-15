package com.skillsync.skillsync_backend.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String icon;

    private boolean isActive;

    private LocalDateTime createdAt;

     // 
    // @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    // private List<UserSkill> userSkills;

    public Skill() {}

    public Skill(String name, SkillCategory category, String description, String icon, boolean isActive) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.icon = icon;
        this.isActive = isActive;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public SkillCategory getCategory() { return category; }

    public void setCategory(SkillCategory category) { this.category = category; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }

    public void setIcon(String icon) { this.icon = icon; }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

     // public List<UserSkill> getUserSkills() { return userSkills; }

    // public void setUserSkills(List<UserSkill> userSkills) { this.userSkills = userSkills; }
}
