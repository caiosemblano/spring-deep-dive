package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.ProfileUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileUserRepository extends JpaRepository<ProfileUserEntity, Long> {
}
