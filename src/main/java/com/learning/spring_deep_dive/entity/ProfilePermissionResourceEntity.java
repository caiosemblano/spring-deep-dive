package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.ProfilePermissionResourceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SDD_PROFILE_PERMISSION_RESOURCE")
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePermissionResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;

    public ProfilePermissionResourceEntity(ProfilePermissionResourceDTO dto) {
        this.profile = dto.getProfile();
        this.resource = dto.getResource();
    }
}
