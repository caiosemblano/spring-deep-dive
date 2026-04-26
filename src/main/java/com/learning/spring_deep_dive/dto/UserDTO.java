package com.learning.spring_deep_dive.dto;

import com.learning.spring_deep_dive.entity.UserEntity;
import com.learning.spring_deep_dive.entity.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
        private long id;
        private String name;
        private String email;
        private String password;
        private String login;
        private UserStatus status;

        public UserDTO(UserEntity userEntity) {
                BeanUtils.copyProperties(userEntity,this);
        }


}
