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
    private String name;
    private String key;


    public ResourceDTO(ResourceEntity resourceEntity) {
    }
}
