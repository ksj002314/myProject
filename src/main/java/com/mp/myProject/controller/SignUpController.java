package com.mp.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/create/signUp")
    public String signUp() {

        return "signUp";
    }
}
