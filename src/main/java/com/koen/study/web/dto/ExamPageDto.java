package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamPageDto {
    private String title;
    private String description;
    private int stopwatch;
    private Boolean isActive;
}
