package com.learning.spring_deep_dive.dto;

import com.learning.spring_deep_dive.entity.ProfileEntity;
import com.learning.spring_deep_dive.entity.ProfileUserEntity;
import com.learning.spring_deep_dive.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserDTO {

    private long id;
    private ProfileEntity profile;
    private UserEntity user;

    public ProfileUserDTO(ProfileUserEntity profileUser) {
        BeanUtils.copyProperties(profileUser, this);
        if (profileUser.getUser() != null) {
            this.user = profileUser.getUser();
        }
        if (profileUser.getProfile() != null) {
            this.profile = profileUser.getProfile();
        }
    }
}
