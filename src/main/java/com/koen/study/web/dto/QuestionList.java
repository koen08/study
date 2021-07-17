package com.koen.study.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionList {
    private List<QuestionAnswerDto> questionAnswerDto;
}
