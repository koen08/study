package com.koen.study.dao;

import com.koen.study.dao.entity.RoleEntity;
import com.koen.study.dao.entity.UserEntity;
import com.koen.study.dao.repo.RoleEntityRepository;
import com.koen.study.dao.repo.UserEntityRepository;
import com.koen.study.security.CustomUserDetails;
import com.koen.study.web.dto.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceDao {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(AuthDto authDto) {
        UserEntity userEntity = new UserEntity();
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_" + authDto.getRole());
        userEntity.setRoleEntity(userRole);
        userEntity.setLogin(authDto.getLogin());
        userEntity.setPassword(authDto.getPassword());
        userEntity.setNickname(authDto.getNick_name());
        userEntity.setId(UUID.randomUUID().toString() + new Date());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity getUserByJwt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String login = userDetails.getUsername();
        return findByLogin(login);
    }
}
