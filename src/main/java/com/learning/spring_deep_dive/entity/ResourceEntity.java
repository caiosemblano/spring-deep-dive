package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.ResourceDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Data
@Entity
@NoArgsConstructor
@Table(name="SDD_RESOURCE")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name = "resource_name")
    private String name;

    @Column(nullable = false, name = "resource_key")
    private String key;

    public ResourceEntity (ResourceDTO resourceDTO) {
        BeanUtils.copyProperties(resourceDTO, this);
    }

}
