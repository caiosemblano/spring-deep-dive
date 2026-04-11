package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.ProfileUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SDD_PROFILE_USER")
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ProfileUserEntity(ProfileUserDTO profileUserDTO) {
        this.profile = profileUserDTO.getProfile();
        this.user = profileUserDTO.getUser();
    }
}
