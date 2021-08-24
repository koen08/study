package com.koen.study.web.exception;

import com.koen.study.dao.ExamServiceDao;
import com.koen.study.dao.UserServiceDao;
import com.koen.study.dao.entity.ExamEntity;
import com.koen.study.dao.entity.UserEntity;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("access")
public class GlobalAccess {
    @Autowired
    ExamServiceDao examServiceDao;
    @Autowired
    UserServiceDao userServiceDao;

    public boolean accessMyExam(@NonNull final UserDetails userDetails) throws AccessException {
        UserEntity userEntity = userServiceDao.findByLogin(userDetails.getUsername());
        return true;
    }

    public boolean accessTryExam(@NonNull final UserDetails userDetails,
                                 @NonNull final Long examId) throws ExamException, MySelfException, CommonException {
        UserEntity userEntity = userServiceDao.findByLogin(userDetails.getUsername());
        ExamEntity examEntity = examServiceDao.getExamId(examId);
        return true;
    }

    public boolean accessToExamPageSettings(@NonNull final UserDetails userDetails, @NonNull final Long examId) throws CommonException {
        UserEntity userEntity = userServiceDao.findByLogin(userDetails.getUsername());
        ExamEntity examEntity = examServiceDao.getExamId(examId);
        for (ExamEntity exam : userEntity.getExamEntities()) {
            if (exam.equals(examEntity)) {
                return true;
            }
        }
        return false;
    }
}
