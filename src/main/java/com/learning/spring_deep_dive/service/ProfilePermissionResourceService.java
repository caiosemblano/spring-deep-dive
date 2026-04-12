package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.ProfilePermissionResourceDTO;
import com.learning.spring_deep_dive.entity.ProfilePermissionResourceEntity;
import com.learning.spring_deep_dive.repository.ProfilePermissionResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePermissionResourceService {
    @Autowired
    private ProfilePermissionResourceRepository repository;

    public List<ProfilePermissionResourceDTO> getAllProfilePermissionResources() {
        List<ProfilePermissionResourceEntity> entities = repository.findAll();
        return entities.stream().map(ProfilePermissionResourceDTO::new).toList();
    }

    public void insertProfilePermissionResource(ProfilePermissionResourceDTO dto) {
        ProfilePermissionResourceEntity entity = new ProfilePermissionResourceEntity(dto);
        repository.save(entity);
    }

    public ProfilePermissionResourceDTO updateProfilePermissionResource(ProfilePermissionResourceDTO dto) {
        ProfilePermissionResourceEntity entity = new ProfilePermissionResourceEntity(dto);
        if (dto.getId() > 0) {
            entity.setId(dto.getId());
        }
        return new ProfilePermissionResourceDTO(repository.save(entity));
    }

    public void deleteProfilePermissionResource(Long id) {
        ProfilePermissionResourceEntity entity = repository.findById(id).get();
        repository.delete(entity);
    }

    public ProfilePermissionResourceDTO getProfilePermissionResourceById(Long id) {
        ProfilePermissionResourceEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProfilePermissionResource not found with id: " + id));
        return new ProfilePermissionResourceDTO(entity);
    }
}
