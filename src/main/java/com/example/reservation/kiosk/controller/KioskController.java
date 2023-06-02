package com.example.reservation.kiosk.controller;

import com.example.reservation.kiosk.model.KioskUserInput;
import com.example.reservation.kiosk.service.KioskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class KioskController {

    private final KioskService kioskService;

    @GetMapping("/kiosk")
    public String kiosk() {

        return "kiosk/index";
    }

    @PostMapping("/kiosk")
    public String kioskComplete(Model model, KioskUserInput parameter) {

        boolean result = kioskService.checkReservation(parameter);
        model.addAttribute("result", result);

        return "kiosk/submit";
    }

}
