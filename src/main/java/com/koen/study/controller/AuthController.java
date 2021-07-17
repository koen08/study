package com.koen.study.controller;

import com.koen.study.service.AuthorizationService;
import com.koen.study.web.dto.AuthDto;
import com.koen.study.web.dto.GenericResponse;
import com.koen.study.web.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class AuthController {
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/register")
    public ResponseEntity<GenericResponse<?>> registerUser(@Valid @RequestBody AuthDto authDto)
            throws CommonException {
        return new ResponseEntity<>(new GenericResponse<>(
                authorizationService.createPerson(authDto)), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse<?>> auth(@NotBlank @RequestHeader("Authorization") String authorizationHeader)
            throws CommonException {
        return new ResponseEntity<>(new GenericResponse<>(authorizationService.createAuthToken(authorizationHeader)), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }
}
