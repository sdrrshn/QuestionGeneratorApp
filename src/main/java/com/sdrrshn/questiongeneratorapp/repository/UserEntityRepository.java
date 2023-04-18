package com.sdrrshn.questiongeneratorapp.repository;

import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}