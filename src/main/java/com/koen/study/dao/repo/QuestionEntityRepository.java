package com.koen.study.dao.repo;

import com.koen.study.dao.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionEntityRepository extends JpaRepository<QuestionEntity, Long> {
}
