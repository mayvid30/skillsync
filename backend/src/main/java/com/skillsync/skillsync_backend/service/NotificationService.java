package com.skillsync.skillsync_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.Notification;
import com.skillsync.skillsync_backend.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public List<Notification> getUserNotifications(Long userId) {
        return repository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public List<Notification> getUnreadNotifications(Long userId) {
        return repository.findByUserIdAndIsReadFalse(userId);
    }

    public Notification getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Notification create(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        return repository.save(notification);
    }

    public Notification markAsRead(Long id) {
        Notification notification = getById(id);
        if (notification == null) return null;

        notification.setRead(true);
        notification.setReadAt(LocalDateTime.now());
        return repository.save(notification);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

