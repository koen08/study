package com.koen.study.web.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AnswerResponse {
    String answerRequest;
    public AnswerResponse(String answer){
        this.answerRequest = answer;
    }
}
