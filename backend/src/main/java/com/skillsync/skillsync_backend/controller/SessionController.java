package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync_backend.model.Session;
import com.skillsync.skillsync_backend.service.SessionService;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    @Autowired private SessionService service;

    @PostMapping public Session create(@RequestBody Session s) { return service.save(s); }
    @GetMapping public List<Session> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Session> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}