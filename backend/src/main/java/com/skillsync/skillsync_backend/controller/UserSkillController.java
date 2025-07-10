package com.skillsync.skillsync_backend.controller;


import com.skillsync.skillsync_backend.model.UserSkill;
import com.skillsync.skillsync_backend.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-skills")
public class UserSkillController {

    private final UserSkillService userSkillService;

    @Autowired
    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @GetMapping
    public List<UserSkill> getAll() {
        return userSkillService.getAll();
    }

    @GetMapping("/{id}")
    public UserSkill getById(@PathVariable Long id) {
        return userSkillService.getById(id)
                .orElseThrow(() -> new RuntimeException("UserSkill not found with id " + id));
    }

    @GetMapping("/user/{userId}")
    public List<UserSkill> getByUserId(@PathVariable Long userId) {
        return userSkillService.getByUserId(userId);
    }

    @PostMapping
    public UserSkill create(@RequestBody UserSkill userSkill) {
        return userSkillService.save(userSkill);
    }

    @PutMapping("/{id}")
    public UserSkill update(@PathVariable Long id, @RequestBody UserSkill userSkill) {
        return userSkillService.update(id, userSkill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userSkillService.delete(id);
    }
}

