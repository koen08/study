package com.koen.study.service;

import com.koen.study.web.dto.QuestionAnswerDto;
import com.koen.study.web.exception.CommonException;

import java.util.List;

public interface QuestionService {
    QuestionAnswerDto createQuestion(QuestionAnswerDto questionAnswerDto) throws CommonException;

    List<QuestionAnswerDto> getQuestionListByExam(Long examId) throws CommonException;

    QuestionAnswerDto getPageQuestion(Long questionId);
}
