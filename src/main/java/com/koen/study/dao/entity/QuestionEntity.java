package com.koen.study.dao.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question_exam")
@TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
)
public class QuestionEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024, nullable = false)
    private String question;
    @Column(name = "question_type", length = 40, nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    @ManyToOne
    @JoinColumn(name = "exam_user_id")
    private ExamEntity examEntity;
    @Column(name = "answers_array", columnDefinition = "text[]")
    @Type( type = "string-array" )
    private String[] answers;
    @Column(name = "correct_answers_array", columnDefinition = "text[]")
    @Type( type = "string-array" )
    private String[] correctAnswers;
}
