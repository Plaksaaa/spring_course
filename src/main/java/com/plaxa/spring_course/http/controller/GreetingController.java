package com.plaxa.spring_course.http.controller;

import com.plaxa.spring_course.dto.UserReadDto;
import com.plaxa.spring_course.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello(ModelAndView view,
                              @RequestParam Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable Integer id) {
        view.setViewName("greeting/hello");

        return view;
    }

    @GetMapping("/hello")
    public String hello2(Model model,
                         @ModelAttribute("userReadDto") UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);

        return "greeting/hello";
    }

    @GetMapping("/bye")
    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
        ModelAndView view = new ModelAndView();
        view.setViewName("greeting/bye");

        return view;
    }
}
