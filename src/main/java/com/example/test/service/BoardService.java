package com.example.test.service;

import com.example.test.domain.Board;
import com.example.test.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    public final BoardRepository boardRepository;


    @Transactional
    public Long join(Board board){
        boardRepository.save(board);
        return board.getId ();
    }

    public List<Board> findMembers(){
        return boardRepository.findAll();
    }

    public Board boardView(Integer id){

        return  boardRepository.findById ( id.longValue());
    }
}

