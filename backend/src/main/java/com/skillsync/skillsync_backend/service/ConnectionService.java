package com.skillsync.skillsync_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync_backend.model.Connection;
import com.skillsync.skillsync_backend.repository.ConnectionRepository;

@Service
  public class ConnectionService {
      @Autowired private ConnectionRepository repository;
      public Connection save(Connection c) { return repository.save(c); }
      public List<Connection> findAll() { return repository.findAll(); }
      public Optional   <Connection> findById(Long id) { return repository.findById(id); }
      public void delete(Long id) { repository.deleteById(id); }
  }