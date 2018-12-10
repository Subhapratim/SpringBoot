package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }
}
