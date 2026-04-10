package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="SDD_PROFILE")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String description;

    public ProfileEntity(ProfileDTO profileDTO) {
        BeanUtils.copyProperties(profileDTO, this);
    }
}
