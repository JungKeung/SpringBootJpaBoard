package com.example.test.service;

import com.example.test.domain.Board;

import com.example.test.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {

//    @Autowired
//    BoardRepository boardRepository;
//
//    @Rollback(false)
//    @Test
//    public void save() {
//
//        Board params = Board.builder()
//                .title("1번 게시글 제목")
//                .context("1번 게시글 내용")
//                .build();
//
//
//        boardRepository.save(params);
//
//
//        Board entity = boardRepository.findOne ( 1L );
//        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
//        assertThat(entity.getContext()).isEqualTo("1번 게시글 내용");
//
//    }
}
