package com.example.test.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    private String email;
    private String password;
    private String city;
    private String birthDate;
    private int phoneNumber;
}