package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
