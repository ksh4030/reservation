package com.example.reservation.restaurant.controller;

import com.example.reservation.restaurant.dto.RestaurantDto;
import com.example.reservation.restaurant.model.RestaurantParam;
import com.example.reservation.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ListController {

    private final RestaurantService restaurantService;

    @RequestMapping("/restaurant/list")
    public String list(Model model, RestaurantParam parameter) {

        List<RestaurantDto> list = restaurantService.list(parameter);
        model.addAttribute("list", list);

        return "/restaurant/list";
    }

    @RequestMapping("/restaurant/detail")
    public String detail(Model model, RestaurantParam parameter) {

        RestaurantDto restaurantDto = restaurantService.detail(parameter.getId());
        model.addAttribute("member", restaurantDto);

        return "/restaurant/detail";
    }
}
