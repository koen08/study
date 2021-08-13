package com.koen.study.service;

import com.koen.study.dao.ExamServiceDao;
import com.koen.study.dao.QuestionServiceDao;
import com.koen.study.dao.entity.QuestionEntity;
import com.koen.study.dao.entity.QuestionType;
import com.koen.study.web.dto.AnswerResponse;
import com.koen.study.web.dto.QuestionAnswerDto;
import com.koen.study.web.dto.QuestionWithDataDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    final ExamServiceDao examServiceDao;
    final QuestionServiceDao questionServiceDao;

    public QuestionServiceImpl(ExamServiceDao examServiceDao, QuestionServiceDao questionServiceDao) {
        this.examServiceDao = examServiceDao;
        this.questionServiceDao = questionServiceDao;
    }

    @Override
    public QuestionAnswerDto createQuestion(QuestionAnswerDto questionAnswerDto) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestion(questionAnswerDto.getQuestion());
        questionEntity.setQuestionType(QuestionType.valueOf(questionAnswerDto.getQuestionType()));
        questionEntity.setExamEntity(examServiceDao.getExamId(questionAnswerDto.getExamId()));
        questionEntity.setAnswers(questionAnswerDto.getAnswers());
        questionEntity.setCorrectAnswers(questionAnswerDto.getAnswersCorrect());
        questionServiceDao.save(questionEntity);
        questionAnswerDto.setId(questionEntity.getId());
        return questionAnswerDto;
    }

    @Override
    public List<QuestionWithDataDto> getQuestionListByExam(Long examId) {
        return null;
    }

    @Override
    public QuestionAnswerDto getPageQuestion(Long questionId) {
        return null;
    }
}
