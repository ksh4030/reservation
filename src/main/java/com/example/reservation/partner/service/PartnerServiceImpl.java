package com.example.reservation.partner.service;

import com.example.reservation.entity.Restaurant;
import com.example.reservation.partner.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PartnerServiceImpl implements PartnerService{

    private final PartnerRepository partnerRepository;

    @Override
    public List<Restaurant> list() {

        return partnerRepository.findAll();
    }
}
