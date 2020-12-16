package com.j4v4code.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/home")
public class HomeController {


    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
