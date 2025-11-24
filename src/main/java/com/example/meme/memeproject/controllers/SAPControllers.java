package com.example.meme.memeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SAPControllers {
    @GetMapping(value= "/**/{path:[^\\.]*}")
    public String forward(){
        return "forward:/";
    }
}
