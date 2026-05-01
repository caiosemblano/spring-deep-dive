package com.learning.spring_deep_dive.controller;


import com.learning.spring_deep_dive.dto.ProfileUserDTO;
import com.learning.spring_deep_dive.service.ProfileUserService;
import lombok.RequiredArgsConstructor;
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
    public List<ProfileUserDTO> getAllProfileUsers() {
        return profileUserService.getAllProfileUsers();
    }

    @PostMapping
    public void createProfileUser(@RequestBody ProfileUserDTO profileUserDTO) {
        profileUserService.insertProfileUser(profileUserDTO);
    }

    @PutMapping
    public ProfileUserDTO updateProfileUser(@RequestBody ProfileUserDTO profileUserDTO) {
        return profileUserService.updateProfileUser(profileUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileUser(@PathVariable("id") Long id) {
        profileUserService.deleteProfileUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ProfileUserDTO getProfileUserById(@PathVariable("id") Long id) {
        return profileUserService.getProfileUserById(id);
    }


}
