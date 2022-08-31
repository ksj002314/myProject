package com.mp.myProject.controller;


import com.mp.myProject.dto.Board;
import com.mp.myProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/notice")
    public String notice(Model model, @PageableDefault(size = 5) Pageable pageable,
                         @RequestParam(required = false, defaultValue = "") String searchText) {
       //   Page<Board> boards = boardRepository.findAll(pageable); // 페이징 처리
        Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText,searchText, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() -4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "notice";
    }

    @GetMapping("/board/create")
    public String create(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board",board);
        }

        return "create";
    }

    @PostMapping("/board/create")
    public String greetingSubmit(@ModelAttribute Board board, Model model) {
       boardRepository.save(board);
        return "redirect:/board/notice";
    }

    /* delete */
    /*@PostMapping("/board/notice/delete")
    public String delete(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return "redirect:/board/notice";
    }*/

}
