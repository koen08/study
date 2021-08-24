package com.koen.study.service;

import com.koen.study.dao.ExamServiceDao;
import com.koen.study.dao.QuestionServiceDao;
import com.koen.study.dao.entity.QuestionEntity;
import com.koen.study.dao.entity.QuestionType;
import com.koen.study.web.dto.QuestionAnswerDto;
import com.koen.study.web.exception.CommonException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    final ExamServiceDao examServiceDao;
    final QuestionServiceDao questionServiceDao;

    public QuestionServiceImpl(ExamServiceDao examServiceDao, QuestionServiceDao questionServiceDao) {
        this.examServiceDao = examServiceDao;
        this.questionServiceDao = questionServiceDao;
    }

    @Override
    public QuestionAnswerDto createQuestion(QuestionAnswerDto questionAnswerDto) throws CommonException {
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
    public List<QuestionAnswerDto> getQuestionListByExam(Long examId) throws CommonException {
        List<QuestionEntity> questionEntities = questionServiceDao.getQuestionListByExam(examId);
        return questionEntities.stream().map(QuestionServiceImpl::questionEntityToQuestionAnswerDto).collect(Collectors.toList());
    }

    public static QuestionAnswerDto questionEntityToQuestionAnswerDto(QuestionEntity questionEntity) {
        return new QuestionAnswerDto(
                questionEntity.getId(),
                questionEntity.getQuestion(),
                questionEntity.getQuestionType().toString(),
                questionEntity.getExamEntity().getId(),
                questionEntity.getAnswers(),
                questionEntity.getCorrectAnswers()
        );
    }

    @Override
    public QuestionAnswerDto getPageQuestion(Long questionId) {
        QuestionEntity questionEntity = questionServiceDao.getQuestion(questionId);
        return new QuestionAnswerDto(
                questionEntity.getId(),
                questionEntity.getQuestion(),
                questionEntity.getQuestionType().toString(),
                questionEntity.getExamEntity().getId(),
                questionEntity.getAnswers(),
                questionEntity.getCorrectAnswers()
        );
    }
}
