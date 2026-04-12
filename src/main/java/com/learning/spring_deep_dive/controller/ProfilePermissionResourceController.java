package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.ProfilePermissionResourceDTO;
import com.learning.spring_deep_dive.service.ProfilePermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile-permission-resource")
@CrossOrigin
public class ProfilePermissionResourceController {
    @Autowired
    private ProfilePermissionResourceService service;

    @GetMapping
    public List<ProfilePermissionResourceDTO> getAllProfilePermissionResources() {
        return service.getAllProfilePermissionResources();
    }

    @PostMapping
    public void createProfilePermissionResource(@RequestBody ProfilePermissionResourceDTO dto) {
        service.insertProfilePermissionResource(dto);
    }

    @PutMapping
    public ProfilePermissionResourceDTO updateProfilePermissionResource(@RequestBody ProfilePermissionResourceDTO dto) {
        return service.updateProfilePermissionResource(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfilePermissionResource(@PathVariable("id") Long id) {
        service.deleteProfilePermissionResource(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ProfilePermissionResourceDTO getProfilePermissionResourceById(@PathVariable("id") Long id) {
        return service.getProfilePermissionResourceById(id);
    }
}
