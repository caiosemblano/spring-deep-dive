package com.learning.spring_deep_dive.controller;


import com.learning.spring_deep_dive.dto.ProfileUserDTO;
import com.learning.spring_deep_dive.service.ProfileUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile-user")
@CrossOrigin
@RequiredArgsConstructor
public class ProfileUserController {
    private final ProfileUserService profileUserService;


    @GetMapping
    public ResponseEntity<List<ProfileUserDTO>> getAllProfileUsers() {
        return ResponseEntity.ok(profileUserService.getAllProfileUsers());
    }

    @PostMapping
    public ResponseEntity<ProfileUserDTO> createProfileUser(@RequestBody ProfileUserDTO profileUserDTO) {
        ProfileUserDTO createdProfileUser = profileUserService.insertProfileUser(profileUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfileUser);
    }

    @PutMapping
    public ResponseEntity<ProfileUserDTO> updateProfileUser(@RequestBody ProfileUserDTO profileUserDTO) {
        return ResponseEntity.ok(profileUserService.updateProfileUser(profileUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileUser(@PathVariable("id") Long id) {
        profileUserService.deleteProfileUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileUserDTO> getProfileUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profileUserService.getProfileUserById(id));
    }


}
