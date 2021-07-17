package com.koen.study.service;


import com.koen.study.web.dto.AnswerResponse;
import com.koen.study.web.dto.AuthDto;
import com.koen.study.web.dto.Token;
import com.koen.study.web.exception.CommonException;

import javax.security.auth.message.AuthException;

public interface AuthorizationService {
    Token createAuthToken(String authorization) throws CommonException;

    AnswerResponse createPerson(AuthDto authDto) throws CommonException;
}