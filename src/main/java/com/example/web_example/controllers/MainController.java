package com.example.web_example.controllers;

import com.example.web_example.models.DairyEntry;
import com.example.web_example.models.User;
import com.example.web_example.models.UserEntryId;
import com.example.web_example.models.UsersEntries;
import com.example.web_example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Column;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/sign_up")
    public String signUp(Model model){
        model.addAttribute("title", "Регистрация");
        return "sign_up";
    }

    @PostMapping("/do_sign_up")
    public String doSignUp(@RequestParam String email, @RequestParam String password,
                           @RequestParam String first_name, @RequestParam String last_name, Model model) {
        User user = new User(email, password, first_name, last_name);
        userRepository.save(user);
        return "redirect:/auth/logout";
    }
}
