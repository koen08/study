package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamPlayResponseDto {
    private long id;
    private List<QuestionAnswerDto> questionAnswerDto;
}
