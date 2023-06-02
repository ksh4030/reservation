package com.example.reservation.restaurant.controller;


import com.example.reservation.restaurant.model.RestaurantInput;
import com.example.reservation.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/partner/restaurant")
    public String restaurantAdd(Model model) {

        return "partner/restaurant";
    }

    @PostMapping("/partner/restaurant")
    public String restaurantAddSubmit(Model model, RestaurantInput parameter) {

        boolean result = restaurantService.add(parameter);

        return "redirect:/partner/restaurant";
    }
}
