package com.learning.spring_deep_dive.service;


import com.learning.spring_deep_dive.dto.ProfileUserDTO;
import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.entity.ProfileUserEntity;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import com.learning.spring_deep_dive.repository.ProfileUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileUserService {
    private final ProfileUserRepository profileUserRepository;

    public List<ProfileUserDTO> getAllProfileUsers() {
        List<ProfileUserEntity> profileUser = profileUserRepository.findAll();
        return profileUser.stream().map(ProfileUserDTO::new).toList();
    }

    public ProfileUserDTO insertProfileUser(ProfileUserDTO profileUserDTO) {
        ProfileUserEntity profileUserEntity = new ProfileUserEntity(profileUserDTO);
        return new ProfileUserDTO(profileUserRepository.save(profileUserEntity));
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
