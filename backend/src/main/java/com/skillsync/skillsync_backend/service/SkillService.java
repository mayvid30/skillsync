package com.skillsync.skillsync_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.Skill;
import com.skillsync.skillsync_backend.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    
    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    // Check if skill exists by name
    // public boolean skillExists(String name) {
    //     return skillRepository.existsByName(name);
    // }
}
