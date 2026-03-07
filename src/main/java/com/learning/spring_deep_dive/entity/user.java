package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.userDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false,  unique=true)
    private String login;

    public user (userDTO userDTO) {
        BeanUtils.copyProperties(userDTO,this);
    }

    public user() {
    }



}
