package com.koen.study.service;

import com.koen.study.web.dto.QuestionAnswerDto;

import java.util.List;

public interface QuestionService {
    QuestionAnswerDto createQuestion(QuestionAnswerDto questionAnswerDto);

    List<QuestionAnswerDto> getQuestionListByExam(Long examId);

    QuestionAnswerDto getPageQuestion(Long questionId);
}
