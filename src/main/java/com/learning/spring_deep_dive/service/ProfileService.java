package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.ProfileDTO;
import com.learning.spring_deep_dive.dto.ResourceDTO;
import com.learning.spring_deep_dive.entity.ProfileEntity;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import com.learning.spring_deep_dive.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public List<ProfileDTO> getAllProfiles() {
        List<ProfileEntity> resources = profileRepository.findAll();
        return resources.stream().map(ProfileDTO::new).toList();
    }

    public void insertProfile(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    public ProfileDTO updateProfile(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    public void deleteProfile(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }

    public ProfileDTO getProfileById(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));
        return new ProfileDTO(profileEntity);
    }
}
