package com.example.test.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;


    private String email;

    private String password;

    private String city;

    private String birthDate;

    private int phoneNumber;


}
