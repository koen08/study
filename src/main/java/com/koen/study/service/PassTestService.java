package com.koen.study.service;

import com.koen.study.dao.QuestionServiceDao;
import com.koen.study.dao.entity.QuestionEntity;
import com.koen.study.dao.entity.QuestionType;
import com.koen.study.web.dto.PassTestDto;
import com.koen.study.web.dto.PassTestDtoRequestList;
import com.koen.study.web.dto.ResultsTestDto;
import com.koen.study.web.exception.CommonException;
import org.springframework.stereotype.Service;

@Service
public class PassTestService {
    final
    QuestionServiceDao questionServiceDao;

    public PassTestService(QuestionServiceDao questionServiceDao) {
        this.questionServiceDao = questionServiceDao;
    }

    public ResultsTestDto passTest(PassTestDtoRequestList passTestDtoRequestList) throws CommonException {
        Integer counterAnswersCorrect = 0;
        for (PassTestDto passTestDto : passTestDtoRequestList.getPassTestDtoList()) {
            QuestionEntity questionEntity = questionServiceDao.getQuestion(passTestDto.getQuestionId());
            if (questionEntity.getExamEntity().getId().equals(passTestDtoRequestList.getExamId())) {
                QuestionType questionType = questionEntity.getQuestionType();
                boolean isCorrectAnswer = questionType.checkCorrectAnswer(
                        passTestDto.getAnswersCorrect(), questionEntity.getCorrectAnswers());
                if (isCorrectAnswer) {
                    counterAnswersCorrect++;
                }
            } else {
                throw new CommonException("ExamId does not match the question", 6);
            }
        }
        return new ResultsTestDto(counterAnswersCorrect);
    }
}
