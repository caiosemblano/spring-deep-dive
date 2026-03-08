package com.learning.spring_deep_dive.dto;

import com.learning.spring_deep_dive.entity.userEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class userDTO {
        private long id;
        private String name;
        private String email;
        private String password;
        private String login;

        public userDTO(userEntity userEntity) {
                BeanUtils.copyProperties(userEntity,this);
        }


}
