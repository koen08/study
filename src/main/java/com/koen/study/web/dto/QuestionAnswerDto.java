package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerDto {
    private Long id;
    private String question;
    private String questionType;
    private Long examId;
    private String[] answers;
    private String[] answersCorrect;
}
