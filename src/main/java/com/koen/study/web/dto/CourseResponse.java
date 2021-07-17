package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponse {
    private String id;
    private String title;
    private String description;
}
