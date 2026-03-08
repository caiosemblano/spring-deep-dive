package com.learning.spring_deep_dive.repository;

import com.learning.spring_deep_dive.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
