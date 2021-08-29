package com.koen.study.controller;

import com.koen.study.service.PassTestService;
import com.koen.study.web.dto.GenericResponse;
import com.koen.study.web.dto.PassTestDtoRequestList;
import com.koen.study.web.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pass")
public class PassTestController {
    final
    PassTestService passTestService;

    public PassTestController(PassTestService passTestService) {
        this.passTestService = passTestService;
    }

    @PostMapping("/exam")
    public ResponseEntity<GenericResponse<?>> passExam(@RequestBody PassTestDtoRequestList passTestDtoRequestList)
            throws CommonException {
        return new ResponseEntity<>(new GenericResponse<>(
                passTestService.passTest(passTestDtoRequestList)), HttpStatus.OK);
    }
}
