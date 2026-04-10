package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.ProfileEntity;
import com.learning.spring_deep_dive.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
