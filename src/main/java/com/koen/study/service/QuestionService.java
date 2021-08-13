package com.koen.study.service;

import com.koen.study.web.dto.AnswerResponse;
import com.koen.study.web.dto.QuestionAnswerDto;
import com.koen.study.web.dto.QuestionWithDataDto;

import java.util.List;

public interface QuestionService {
    QuestionAnswerDto createQuestion(QuestionAnswerDto questionAnswerDto);

    List<QuestionWithDataDto> getQuestionListByExam(Long examId);

    QuestionAnswerDto getPageQuestion(Long questionId);
}
