package com.koen.study.dao;

import com.koen.study.dao.entity.QuestionEntity;
import com.koen.study.dao.repo.QuestionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceDao {
    @Autowired
    QuestionEntityRepository questionEntityRepository;

    public QuestionEntity save(QuestionEntity questionEntity) {
        return questionEntityRepository.save(questionEntity);
    }

    public QuestionEntity getQuestion(Long questionId) {
        return questionEntityRepository.findById(questionId).get();
    }
}
