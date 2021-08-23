package com.koen.study.dao.repo;

import com.koen.study.dao.entity.ExamEntity;
import com.koen.study.dao.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionEntityRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> getAllByExamEntity(ExamEntity examEntity);
}
