package com.example.test.domain;


import lombok.*;

import javax.persistence.*;


@Getter @Setter
@Entity
public class Board {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;


    private String email;
    private String title;
    private String context;

    @Builder
    public Board() {
        this.id = id;
        this.email = email;
        this.title = title;
        this.context = context;

    }
}