package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.userDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="SDD_USER")
public class userEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false,  unique=true)
    private String login;

    public userEntity(userDTO userDTO) {
        BeanUtils.copyProperties(userDTO,this);
    }

    public userEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        userEntity that = (userEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
