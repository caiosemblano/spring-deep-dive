package com.learning.spring_deep_dive.controller;


import com.learning.spring_deep_dive.dto.ProfileDTO;
import com.learning.spring_deep_dive.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;


    @GetMapping
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profileService.insertProfile(profileDTO));
    }

    @PutMapping
    public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.updateProfile(profileDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }


}
