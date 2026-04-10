package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> listAllResources() {
        return resourceService.listAllResources();
    }

    @PostMapping
    public ResourceDTO createResource(@RequestBody ResourceDTO resourceDTO) {
        resourceService.insertResource(resourceDTO);
        return resourceDTO;
    }

    @PutMapping
    public ResourceDTO updateResource(@RequestBody ResourceDTO resourceDTO) {
        return resourceService.updateResource(resourceDTO);
    }
t

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable("id") Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResourceDTO getResourceById(@PathVariable("id") Long id) {
        return resourceService.getResourceById(id);
    }
}
