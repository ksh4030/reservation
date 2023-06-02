package com.example.reservation.restaurant.controller;

import com.example.reservation.entity.Reservation;
import com.example.reservation.restaurant.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RestaurantReservationController {

    private final ReservationService reservationService;

    @GetMapping("/restaurant/reservation")
    public String checkReservation(Model model, Principal principal) {

        String userId = principal.getName();

        List<Reservation> list = reservationService.list();
        List<Reservation> newList = new ArrayList<>();

        for(Reservation x : list) {
            if(x.getUserId().equals(userId)){
                newList.add(x);
            }
        }

        model.addAttribute("list", newList);

        return "restaurant/reservation";
    }

}
