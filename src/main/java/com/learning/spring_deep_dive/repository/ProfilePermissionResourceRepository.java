package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.ProfilePermissionResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePermissionResourceRepository extends JpaRepository<ProfilePermissionResourceEntity, Long> {
}
