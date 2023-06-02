package com.example.reservation.restaurant.controller;


import com.example.reservation.entity.User;
import com.example.reservation.member.model.UserInput;
import com.example.reservation.member.repository.UserRepository;
import com.example.reservation.member.service.UserService;
import com.example.reservation.restaurant.model.TakeRestaurantInput;
import com.example.reservation.restaurant.service.RestaurantService;
import com.example.reservation.restaurant.service.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class ApiRestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/api/restaurant/req.api")
    public ResponseEntity<?> restaurantReq(Model model,
                                           @RequestBody TakeRestaurantInput parameter,
                                           Principal principal) {

        String userId = principal.getName();

        parameter.setUserId(userId);
        User user = userService.find(userId);

        parameter.setName(user.getName());
        parameter.setPhone(user.getPhone());

        ServiceResult result = restaurantService.req(parameter);

        if(!result.isResult()){
            return ResponseEntity.ok().body(result.getMessage());
        }

        return ResponseEntity.ok().body(parameter);
    }

}
