package com.skillsync.skillsync_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.Session;
import com.skillsync.skillsync_backend.repository.SessionRepository;

@Service
public class SessionService {
    @Autowired private SessionRepository repository;
    public Session save(Session s) { return repository.save(s); }
    public List<Session> findAll() { return repository.findAll(); }
    public Optional<Session> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
