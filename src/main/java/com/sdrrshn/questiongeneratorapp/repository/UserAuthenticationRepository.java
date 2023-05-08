package com.sdrrshn.questiongeneratorapp.repository;

import com.sdrrshn.questiongeneratorapp.entity.UserAuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthenticationEntity, Long> {
    Optional<UserAuthenticationEntity> findByAuthCode(String AuthCode);
}
