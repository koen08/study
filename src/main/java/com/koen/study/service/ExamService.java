package com.koen.study.service;

import com.koen.study.web.dto.ExamDto;
import com.koen.study.web.dto.ExamPageDto;
import com.koen.study.web.exception.AccessException;
import com.koen.study.web.exception.CommonException;

import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamDto examDto) throws AccessException;

    ExamPageDto getExamPage(Long id) throws CommonException;

    ExamPageDto getExamPageForPlayer(Long id) throws CommonException;

    List<ExamDto> getListExamUser();
}
