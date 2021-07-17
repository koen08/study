package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;
    @NotBlank(message = "Поле title не может быть пустым")
    private String title;
    @NotBlank(message = "Поле description не может быть пустым")
    private String description;
    private int stopwatch;
    private boolean isActive;
}
