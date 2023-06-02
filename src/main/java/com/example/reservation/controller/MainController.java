package com.example.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }

    @GetMapping("/error/error")
    public String errorPage() {
        return "error/error";
    }


}
