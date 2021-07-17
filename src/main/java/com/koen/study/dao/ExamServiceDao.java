package com.koen.study.dao;

import com.koen.study.dao.entity.ExamEntity;
import com.koen.study.dao.entity.UserEntity;
import com.koen.study.dao.repo.ExamEntityRepository;
import com.koen.study.dao.repo.UserEntityRepository;
import com.koen.study.web.dto.ExamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceDao {
    @Autowired
    ExamEntityRepository examEntityRepository;
    @Autowired
    UserEntityRepository userEntityRepository;

    public ExamEntity createExam(ExamEntity examEntity) {
        return examEntityRepository.save(examEntity);
    }

    public ExamEntity getExamId(Long examId) {
        return examEntityRepository.findById(examId).get();
    }

    public List<ExamEntity> getAllByUserEntity(UserEntity userEntity) {
        return examEntityRepository.getAllByUserEntity(userEntity);
    }
}
