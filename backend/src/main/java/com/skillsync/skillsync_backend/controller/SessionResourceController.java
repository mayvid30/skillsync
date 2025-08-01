package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsync.skillsync_backend.model.SessionResource;
import com.skillsync.skillsync_backend.service.SessionResourceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/session-resources")
public class SessionResourceController {

    @Autowired
    private SessionResourceService service;

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<SessionResource>> getBySession(@PathVariable Long sessionId) {
        return ResponseEntity.ok(service.getBySessionId(sessionId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResource> getById(@PathVariable Long id) {
        SessionResource resource = service.getById(id);
        return resource != null ? ResponseEntity.ok(resource) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SessionResource> create(@RequestBody SessionResource resource) {
        return ResponseEntity.ok(service.create(resource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionResource> update(@PathVariable Long id, @RequestBody SessionResource updated) {
        SessionResource resource = service.update(id, updated);
        return resource != null ? ResponseEntity.ok(resource) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

