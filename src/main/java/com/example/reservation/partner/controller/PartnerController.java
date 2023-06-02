package com.example.reservation.partner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PartnerController {

    @GetMapping("/partner")
    public String partnerIndex() {
        return "partner/index";
    }


}
