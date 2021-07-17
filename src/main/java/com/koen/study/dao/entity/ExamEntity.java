package com.koen.study.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exam_user")
public class ExamEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(length = 1024)
    private String description;
    @Column(name = "stopwatch")
    private int stopwatch;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "auth_user_id")
    private UserEntity userEntity;
}
