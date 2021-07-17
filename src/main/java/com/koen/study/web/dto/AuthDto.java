package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {

    @NotBlank(message = "Поле login не может быть пустым")
    @Email(message = "Некорректно введен адрес электронной почты")
    private String login;
    @NotBlank(message = "Поле password не может быть пустым")
    @Size(min = 8, message = "Минимальная длина пароля 8 символов")
    private String password;
    @NotBlank(message = "Поле nick_name не может быть пустым")
    private String nick_name;
    @NotBlank(message = "Поле role не может быть пустым")
    private String role;
}
