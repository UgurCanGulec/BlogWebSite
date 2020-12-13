package com.j4v4code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/second")
    public String secondMethod() {
        return "views/second";
    }
}
