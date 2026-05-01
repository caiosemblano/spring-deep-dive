package com.learning.spring_deep_dive.controller;


import com.learning.spring_deep_dive.dto.ProfileDTO;
import com.learning.spring_deep_dive.service.ProfileService;
import lombok.RequiredArgsConstructor;
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
    public List<ProfileDTO> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PostMapping
    public void createProfile(@RequestBody ProfileDTO profileDTO) {
        profileService.insertProfile(profileDTO);
    }

    @PutMapping
    public ProfileDTO updateProfile(@RequestBody ProfileDTO profileDTO) {
        return profileService.updateProfile(profileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ProfileDTO getProfileById(@PathVariable("id") Long id) {
        return profileService.getProfileById(id);
    }


}
