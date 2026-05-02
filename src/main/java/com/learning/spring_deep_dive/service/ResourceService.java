package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import com.learning.spring_deep_dive.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public List<ResourceDTO> getAllResources() {
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    public ResourceDTO insertResource(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    public ResourceDTO updateResource(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    public void deleteResource(Long id) {
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

    public ResourceDTO getResourceById(Long id) {
        ResourceEntity resourceEntity = resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));
        return new ResourceDTO(resourceEntity);
    }
}
