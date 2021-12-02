package com.example.test.controller;

import com.example.test.domain.Board;
import com.example.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board")
    public String boardCreated(Model model){
        model.addAttribute ( "boardForm", new BoardForm());
        return "board/createdBoard";
    }

    @PostMapping("/board")
    public String boardCreate(@Valid BoardForm form, BindingResult result){

        if (result.hasErrors()) {
            return "board/createdBoard";
        }

        Board board = new Board() ;
        board.setTitle (form.getTitle ());
        board.setEmail (form.getEmail ());
        board.setContext (form.getContext());
        boardService.join (board);
        return "redirect:/";

    }

    @GetMapping("/board/list")
    public String list(Model model){
        List<Board> board = boardService.findMembers ();
        model.addAttribute ("board", board);
        return "/board/boardList";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){

        model.addAttribute ("board", boardService.boardView (id));
        return "board/boardView";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model){

        model.addAttribute ( "board", boardService.boardView(id));
        return  "board/boardModify";
    }
}
