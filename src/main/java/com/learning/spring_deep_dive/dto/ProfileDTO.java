package com.learning.spring_deep_dive.dto;

import com.learning.spring_deep_dive.entity.ProfileEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ProfileDTO {

    private long id;
    private String description;

    public ProfileDTO(ProfileEntity profileEntity) {
        BeanUtils.copyProperties(profileEntity, this);
    }
}
