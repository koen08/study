package com.koen.study.controller;

import com.koen.study.service.QuestionService;
import com.koen.study.web.dto.GenericResponse;
import com.koen.study.web.dto.QuestionAnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    final
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse<?>> createExam(@RequestBody QuestionAnswerDto questionAnswerDto) {
        return new ResponseEntity<>(new GenericResponse<>(
                questionService.createQuestion(questionAnswerDto)), HttpStatus.OK);
    }

    @GetMapping("/list/{examId}")
    public ResponseEntity<GenericResponse<?>> getListQuestion(@PathVariable Long examId) {
        return new ResponseEntity<>(new GenericResponse<>(
                questionService.getQuestionListByExam(examId)), HttpStatus.OK);
    }

    @GetMapping("/page/{questionId}")
    public ResponseEntity<GenericResponse<?>> getAnswerListByQuestion(@PathVariable Long questionId) {
        return new ResponseEntity<>(new GenericResponse<>(
                questionService.getPageQuestion(questionId)), HttpStatus.OK);
    }
}
