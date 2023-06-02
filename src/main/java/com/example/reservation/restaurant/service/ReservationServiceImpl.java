package com.example.reservation.restaurant.service;


import com.example.reservation.entity.Reservation;
import com.example.reservation.restaurant.repository.TakeReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService{

    private final TakeReservationRepository takeReservationRepository;

    @Override
    public List<Reservation> list() {

        return takeReservationRepository.findAll();
    }
}
