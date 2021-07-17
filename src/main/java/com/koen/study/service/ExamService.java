package com.koen.study.service;

import com.koen.study.web.dto.ExamDto;
import com.koen.study.web.dto.ExamPageDto;
import com.koen.study.web.exception.AccessException;

import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamDto examDto) throws AccessException;

    ExamPageDto getExamPage(Long id);

    List<ExamDto> getListExamUser();
}
