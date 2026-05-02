package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> createResource(@RequestBody ResourceDTO resourceDTO) {
        ResourceDTO createdResource = resourceService.insertResource(resourceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

    @PutMapping
    public ResponseEntity<ResourceDTO> updateResource(@RequestBody ResourceDTO resourceDTO) {
        return ResponseEntity.ok(resourceService.updateResource(resourceDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable("id") Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(resourceService.getResourceById(id));
    }
}
