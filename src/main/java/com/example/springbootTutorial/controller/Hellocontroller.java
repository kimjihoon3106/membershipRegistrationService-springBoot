package com.example.springbootTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hellocontroller {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","jihoon");
        return "hello/hello";
    }
}
