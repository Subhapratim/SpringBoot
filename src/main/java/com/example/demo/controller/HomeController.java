package com.example.demo.controller;

import com.example.demo.Bean.UserBean;
import com.example.demo.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/dashboard")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/signin")
    public String loginPage(@ModelAttribute("signin") UserBean userBean){
        if (homeService.getUser(userBean))
            return "home";
        else
            return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping("/signup")
    public String registrationPage(@ModelAttribute("signup") UserBean userBean){
        if (homeService.addUser(userBean))
            return "home";
        else
            return "registration";
    }
}
