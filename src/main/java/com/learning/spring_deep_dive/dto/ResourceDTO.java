package com.learning.spring_deep_dive.dto;


import com.learning.spring_deep_dive.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO {
    private Long id;
    private String nome;
    private String chave;


    public ResourceDTO(ResourceEntity resourceEntity) {
    }
}
