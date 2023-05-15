package com.sdrrshn.questiongeneratorapp.repository;

import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    @Query("from UserEntity as us where us.username=:username")
    Optional<UserEntity> findByUsername(@Param("username") String userName);

    @Query("from UserEntity as us where us.username=:username or us.email=:email or us.phone=:phone")
    Optional<UserEntity> getUserForUserAdd(String username, String email, String phone);
}