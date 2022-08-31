package com.mp.myProject.controller;

import com.mp.myProject.dto.Board;
import com.mp.myProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/index")
    public String index(Model model) {
        Page<Board> boards = boardRepository.findAll(PageRequest.of(0, 4)); // 페이징 처리
        model.addAttribute("boards", boards);
        return "index";
    }

}
