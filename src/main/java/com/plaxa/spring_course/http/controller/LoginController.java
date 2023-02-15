package com.plaxa.spring_course.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

//    @PostMapping("/login")
//    public String login(Model model, LoginDto loginDto) {
//        return "redirect:/login";
//    }
}
