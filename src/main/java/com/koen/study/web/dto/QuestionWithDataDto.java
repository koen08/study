package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWithDataDto {
    private Long id;
    private String question;
    private String questionType;
    private Long examId;
    private float questionScore;
    private AnalysisDto analysisDto;
}
