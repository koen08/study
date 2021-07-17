package com.koen.study.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "auth_user")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;
    @Column
    private String login;
    @Column
    private String password;
    @Column(name = "nick_name")
    private String nickname;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}
