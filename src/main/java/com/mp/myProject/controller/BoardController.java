package com.mp.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/notice")
    public String notice() {

        return "notice";
    }

    @GetMapping("/board/create")
    public String create() {

        return "create";
    }


}
