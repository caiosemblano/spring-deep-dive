package com.learning.spring_deep_dive.service;


import com.learning.spring_deep_dive.dto.ProfileUserDTO;
import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.entity.ProfileUserEntity;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import com.learning.spring_deep_dive.repository.ProfileUserRepository;
import com.learning.spring_deep_dive.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileUserService {
    @Autowired
    private ProfileUserRepository profileUserRepository;

    public List<ProfileUserDTO> getAllProfileUsers() {
        List<ProfileUserEntity> profileUser = profileUserRepository.findAll();
        return profileUser.stream().map(ProfileUserDTO::new).toList();
    }

    public void insertProfileUser(ProfileUserDTO profileUserDTO) {
        ProfileUserEntity profileUserEntity = new ProfileUserEntity(profileUserDTO);
        profileUserRepository.save(profileUserEntity);
    }

    public ProfileUserDTO updateProfileUser(ProfileUserDTO profileUserDTO) {
        ProfileUserEntity profileUserEntity = new ProfileUserEntity(profileUserDTO);
        return new ProfileUserDTO(profileUserRepository.save(profileUserEntity));
    }

    public void deleteProfileUser(Long id) {
        ProfileUserEntity profileUserEntity = profileUserRepository.findById(id).get();
        profileUserRepository.delete(profileUserEntity);
    }

    public ProfileUserDTO getProfileUserById(Long id) {
        ProfileUserEntity profileUserEntity = profileUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("profileUser not found with id: " + id));
        return new ProfileUserDTO(profileUserEntity);
    }
}
