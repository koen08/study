package com.koen.study.service;

import com.koen.study.dao.ExamServiceDao;
import com.koen.study.dao.UserServiceDao;
import com.koen.study.dao.entity.ExamEntity;
import com.koen.study.web.dto.ExamDto;
import com.koen.study.web.dto.ExamPageDto;
import com.koen.study.web.exception.CommonException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {
    final ExamServiceDao examServiceDao;
    final UserServiceDao userServiceDao;

    public ExamServiceImpl(ExamServiceDao examServiceDao, UserServiceDao userServiceDao) {
        this.examServiceDao = examServiceDao;
        this.userServiceDao = userServiceDao;
    }

    @Override
    public ExamDto createExam(ExamDto examDto) {
        ExamEntity examEntity = new ExamEntity();
        examEntity.setTitle(examDto.getTitle());
        examEntity.setDescription(examDto.getDescription());
        examEntity.setStopwatch(examDto.getStopwatch());
        examEntity.setActive(examDto.isActive());
        examEntity.setUserEntity(userServiceDao.getUserByJwt());
        examEntity = examServiceDao.createExam(examEntity);
        examDto.setId(examEntity.getId());
        return examDto;
    }

    @Override
    public ExamPageDto getExamPage(Long id) throws CommonException {
        ExamEntity examEntity = examServiceDao.getExamId(id);
        return new ExamPageDto(examEntity.getTitle(),
                examEntity.getDescription(), examEntity.getStopwatch(), examEntity.isActive());
    }

    @Override
    public ExamPageDto getExamPageForPlayer(Long id) throws CommonException {
        ExamPageDto examPage = getExamPage(id);
        examPage.setIsActive(null);
        return examPage;
    }


    @Override
    public List<ExamDto> getListExamUser() {
        List<ExamEntity> examEntities = examServiceDao.getAllByUserEntity(userServiceDao.getUserByJwt());
        return examEntities.
                stream().
                map(ExamServiceImpl::examEntityToExamDto).
                collect(Collectors.toList());
    }
    public static ExamDto examEntityToExamDto(ExamEntity examEntity){
        return new ExamDto(
                examEntity.getId(),
                examEntity.getTitle(),
                examEntity.getDescription(),
                examEntity.getStopwatch(),
                true
        );
    }
}
