package com.example.web_example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/author")
    public String author(Model model){
        model.addAttribute("title", "Страница об авторе");
        return "author";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "redirect:auth/login";
    }

    @GetMapping("/plans")
    public String plans(Model model){
        model.addAttribute("title", "Планы");
        return "plans";
    }
}
