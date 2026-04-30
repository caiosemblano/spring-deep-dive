package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.UserVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserVerificationRepository extends JpaRepository<UserVerificationEntity, Long> {
    Optional<UserVerificationEntity> findByUuid(UUID uuid);
    Optional<UserVerificationEntity> findByUser_Id(Long userId);
}
