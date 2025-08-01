package com.skillsync.skillsync_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.SessionResource;
import com.skillsync.skillsync_backend.repository.SessionResourceRepository;

@Service
public class SessionResourceService {

    @Autowired
    private SessionResourceRepository repository;

    public List<SessionResource> getBySessionId(Long sessionId) {
        return repository.findBySessionId(sessionId);
    }

    public SessionResource getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public SessionResource create(SessionResource sessionResource) {
        sessionResource.setAssignedAt(LocalDateTime.now());
        return repository.save(sessionResource);
    }

    public SessionResource update(Long id, SessionResource updated) {
        SessionResource existing = getById(id);
        if (existing == null) return null;

        existing.setNotes(updated.getNotes());
        existing.setCompleted(updated.isCompleted());
        existing.setCompletedAt(updated.isCompleted() ? LocalDateTime.now() : null);

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

