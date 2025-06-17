package com.skillsync.skillsync_backend.service;


import com.skillsync.skillsync_backend.model.User;
import com.skillsync.skillsync_backend.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // You'll need to configure this
    
    public User createUser(User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
}
    
    // Add other business methods as needed
}
