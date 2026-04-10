package com.learning.spring_deep_dive.entity;


import com.learning.spring_deep_dive.dto.ResourceDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="SDD_RECURSO")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String chave;

    public ResourceEntity (ResourceDTO resourceDTO) {
        BeanUtils.copyProperties(resourceDTO, this);
    }

}
