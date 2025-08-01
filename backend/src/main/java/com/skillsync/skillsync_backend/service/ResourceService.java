package com.skillsync.skillsync_backend.service;

import com.skillsync.skillsync_backend.model.Resource;
import com.skillsync.skillsync_backend.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        Optional<Resource> resource = resourceRepository.findById(id);
        return resource.orElse(null);
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Long id, Resource updatedResource) {
        Optional<Resource> existingOpt = resourceRepository.findById(id);
        if (existingOpt.isPresent()) {
            Resource existing = existingOpt.get();
            existing.setTitle(updatedResource.getTitle());
            existing.setDescription(updatedResource.getDescription());
            existing.setUrl(updatedResource.getUrl());
            existing.setContent(updatedResource.getContent());
            existing.setSkillTags(updatedResource.getSkillTags());
            existing.setResourceType(updatedResource.getResourceType());
            existing.setDifficultyLevel(updatedResource.getDifficultyLevel());
            existing.setIsPublic(updatedResource.getIsPublic());
            return resourceRepository.save(existing);
        }
        return null;
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}

