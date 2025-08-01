package com.skillsync.skillsync_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync_backend.model.Connection;
import com.skillsync.skillsync_backend.service.ConnectionService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
    @Autowired private ConnectionService service;

    @PostMapping public Connection create(@RequestBody Connection c) {
         return service.save(c); 
        }
        
    @GetMapping public List<Connection> getAll() {
         return service.findAll(); 
        }

    @GetMapping("/{id}") public ResponseEntity<Connection> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
         service.delete(id); }
         
}