package com.example.reservation.review.controller;

import com.example.reservation.review.model.ReviewInput;
import com.example.reservation.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/review")
    public String review(Model model, Principal principal) {

        boolean result = reviewService.checkReview(principal.getName());
        model.addAttribute("result", result);

        return "/review/index";
    }

    @PostMapping("/review")
    public String review(Model model, ReviewInput parameter, Principal principal) {

        boolean result = reviewService.registerReview(principal.getName(), parameter);
        System.out.println(principal.getName());
        model.addAttribute("result", result);

        return "/review/commit";
    }

}
