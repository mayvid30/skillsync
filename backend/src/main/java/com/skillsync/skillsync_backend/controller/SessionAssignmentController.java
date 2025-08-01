package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync_backend.model.SessionAssignment;
import com.skillsync.skillsync_backend.service.SessionAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class SessionAssignmentController {
    @Autowired private SessionAssignmentService service;

    @PostMapping public SessionAssignment create(@RequestBody SessionAssignment sa) {
         return service.save(sa);
    }
        
    @GetMapping public List<SessionAssignment> getAll() {
         return service.findAll(); 
    }

    @GetMapping("/{id}") public ResponseEntity<SessionAssignment> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
         service.delete(id); 
    }
}
