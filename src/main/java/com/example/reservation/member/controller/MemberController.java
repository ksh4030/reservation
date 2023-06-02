package com.example.reservation.member.controller;

import com.example.reservation.member.model.UserInput;
import com.example.reservation.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/register")
    public String register() {
        return "member/register";
    }

    @PostMapping("/register")
    public String registerSubmit(Model model, UserInput parameter) {

        boolean result = userService.register(parameter);
        model.addAttribute("result", result);

        return "member/register_complete";
    }

}
