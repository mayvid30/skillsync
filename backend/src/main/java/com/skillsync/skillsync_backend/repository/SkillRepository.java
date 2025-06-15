package com.skillsync.skillsync_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsync.skillsync_backend.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Optional<Skill> findByName(String name);
    // boolean existsByName(String name);
}
