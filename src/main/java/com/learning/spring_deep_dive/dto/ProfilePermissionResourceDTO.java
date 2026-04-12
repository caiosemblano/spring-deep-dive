package com.learning.spring_deep_dive.dto;

import com.learning.spring_deep_dive.entity.ProfileEntity;
import com.learning.spring_deep_dive.entity.ProfilePermissionResourceEntity;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePermissionResourceDTO {

    private long id;
    private ProfileEntity profile;
    private ResourceEntity resource;

    public ProfilePermissionResourceDTO(ProfilePermissionResourceEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if (entity.getProfile() != null) {
            this.profile = entity.getProfile();
        }
        if (entity.getResource() != null) {
            this.resource = entity.getResource();
        }
    }
}
