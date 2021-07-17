package com.koen.study.dao.repo;

import com.koen.study.dao.entity.ExamEntity;
import com.koen.study.dao.entity.UserEntity;
import com.koen.study.web.dto.ExamDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamEntityRepository extends JpaRepository<ExamEntity, Long> {
    List<ExamEntity> getAllByUserEntity(UserEntity userEntity);
}
