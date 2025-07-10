package com.skillsync.skillsync_backend.service;


import com.skillsync.skillsync_backend.model.UserSkill;
import com.skillsync.skillsync_backend.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;

    @Autowired
    public UserSkillService(UserSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public List<UserSkill> getAll() {
        return userSkillRepository.findAll();
    }

    public Optional<UserSkill> getById(Long id) {
        return userSkillRepository.findById(id);
    }

    public List<UserSkill> getByUserId(Long userId) {
        return userSkillRepository.findByUserId(userId);
    }

    public UserSkill save(UserSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    public UserSkill update(Long id, UserSkill updated) {
        return userSkillRepository.findById(id).map(existing -> {
            existing.setSkill(updated.getSkill());
            existing.setUser(updated.getUser());
            existing.setSkillType(updated.getSkillType());
            existing.setProficiencyLevel(updated.getProficiencyLevel());
            existing.setYearsExperience(updated.getYearsExperience());
            existing.setDescription(updated.getDescription());
            return userSkillRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("UserSkill not found with id " + id));
    }

    public void delete(Long id) {
        userSkillRepository.deleteById(id);
    }
}

