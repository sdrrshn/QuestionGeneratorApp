package com.sdrrshn.questiongeneratorapp.repository;

import com.sdrrshn.questiongeneratorapp.entity.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersEntityRepository extends JpaRepository<AnswersEntity, Long> {
}