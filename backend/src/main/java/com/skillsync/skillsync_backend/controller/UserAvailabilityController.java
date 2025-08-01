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

import com.skillsync.skillsync_backend.service.UserAvailabilityService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/availability")
public class UserAvailabilityController {

    @Autowired
    private UserAvailabilityService service;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<com.skillsync.skillsync_backend.model.UserAvailability>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<com.skillsync.skillsync_backend.model.UserAvailability>> getActive(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getActiveByUserId(userId));
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<UserAvailability> getById(@PathVariable Long id) {
    //     UserAvailability availability = service.getById(id);
    //     return availability != null ? ResponseEntity.ok(availability) : ResponseEntity.notFound().build();
    // }

    // @PostMapping
    // public ResponseEntity<UserAvailability> create(@RequestBody UserAvailability availability) {
    //     return ResponseEntity.ok(service.create(availability));
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<UserAvailability> update(@PathVariable Long id, @RequestBody UserAvailability updated) {
    //     UserAvailability availability = service.update(id, updated);
    //     return availability != null ? ResponseEntity.ok(availability) : ResponseEntity.notFound().build();
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

