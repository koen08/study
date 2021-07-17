package com.koen.study.dao.repo;

import com.koen.study.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
    UserEntity findById(String id);
}
