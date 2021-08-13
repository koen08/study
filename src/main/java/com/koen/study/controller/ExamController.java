package com.koen.study.controller;

import com.koen.study.service.ExamService;
import com.koen.study.web.dto.ExamDto;
import com.koen.study.web.dto.GenericResponse;
import com.koen.study.web.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService examService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse<?>> createExam(@Valid @RequestBody ExamDto examDto)
            throws AccessException {
        return new ResponseEntity<>(new GenericResponse<>(
                examService.createExam(examDto)), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') and @access.accessToExamPageSettings(principal, #examId)")
    @GetMapping("/page/{examId}")
    public ResponseEntity<GenericResponse<?>> getExamPage(@PathVariable Long examId) {
        return new ResponseEntity<>(new GenericResponse<>(
                examService.getExamPage(examId)), HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<GenericResponse<?>> getListExamUser() {
        return new ResponseEntity<>(new GenericResponse<>(
                examService.getListExamUser()), HttpStatus.OK);
    }
}
