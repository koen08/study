package com.koen.study.dao;

import com.koen.study.dao.entity.QuestionEntity;
import com.koen.study.dao.repo.QuestionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceDao {
    @Autowired
    QuestionEntityRepository questionEntityRepository;
    @Autowired
    ExamServiceDao examServiceDao;

    public QuestionEntity save(QuestionEntity questionEntity) {
        return questionEntityRepository.save(questionEntity);
    }

    public List<QuestionEntity> getQuestionListByExam(Long idExam) {
        return questionEntityRepository.getAllByExamEntity(examServiceDao.getExamId(idExam));
    }

    public QuestionEntity getQuestion(Long questionId) {
        return questionEntityRepository.findById(questionId).get();
    }
}
