package com.skillsync.skillsync_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.SessionAssignment;
import com.skillsync.skillsync_backend.repository.SessionAssignmentRepository;

@Service
public class SessionAssignmentService {
    @Autowired private SessionAssignmentRepository repository;
    public SessionAssignment save(SessionAssignment sa) { return repository.save(sa); }
    public List<SessionAssignment> findAll() { return repository.findAll(); }
    public Optional<SessionAssignment> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
