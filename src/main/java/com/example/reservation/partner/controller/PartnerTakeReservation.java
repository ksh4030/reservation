package com.example.reservation.partner.controller;

import com.example.reservation.entity.Reservation;
import com.example.reservation.partner.model.TakeReservationParam;
import com.example.reservation.partner.service.TakeReservationService;
import com.example.reservation.restaurant.service.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PartnerTakeReservation {

    private final TakeReservationService takeReservationService;

    @GetMapping("/partner/reservation")
    public String reservation(Model model, Principal principal) {

        String userId = principal.getName();
        List<Reservation> list = takeReservationService.list();
        List<Reservation> newList = new ArrayList<>();

        for (Reservation x : list) {
            if (userId.equals(x.getPartnerId())) {
                newList.add(x);
            }
        }

        model.addAttribute("list", newList);

        return "partner/reservation";
    }

    @PostMapping("/partner/reservation/status")
    public String changeStatus(Model model, TakeReservationParam parameter) {

        ServiceResult result = takeReservationService.updateStatus(parameter.getId(), parameter.getStatus());
        if (!result.isResult()) {
            return "error/error";
        }

        return "redirect:/partner/reservation";

    }

}
