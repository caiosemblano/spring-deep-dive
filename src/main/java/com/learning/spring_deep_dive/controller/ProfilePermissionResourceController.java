package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.ProfilePermissionResourceDTO;
import com.learning.spring_deep_dive.service.ProfilePermissionResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile-permission-resource")
@CrossOrigin
@RequiredArgsConstructor
public class ProfilePermissionResourceController {
    private final ProfilePermissionResourceService service;

    @GetMapping
    public ResponseEntity<List<ProfilePermissionResourceDTO>> getAllProfilePermissionResources() {
        return ResponseEntity.ok(service.getAllProfilePermissionResources());
    }

    @PostMapping
    public ResponseEntity<ProfilePermissionResourceDTO> createProfilePermissionResource(@RequestBody ProfilePermissionResourceDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertProfilePermissionResource(dto));
    }

    @PutMapping
    public ResponseEntity<ProfilePermissionResourceDTO> updateProfilePermissionResource(@RequestBody ProfilePermissionResourceDTO dto) {
        return ResponseEntity.ok(service.updateProfilePermissionResource(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfilePermissionResource(@PathVariable("id") Long id) {
        service.deleteProfilePermissionResource(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfilePermissionResourceDTO> getProfilePermissionResourceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getProfilePermissionResourceById(id));
    }
}
