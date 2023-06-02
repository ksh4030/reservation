package com.example.reservation.kiosk.service;

import com.example.reservation.entity.Reservation;
import com.example.reservation.entity.Review;
import com.example.reservation.kiosk.model.KioskUserInput;
import com.example.reservation.kiosk.repository.ReviewRepository;
import com.example.reservation.restaurant.repository.TakeReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KioskServiceImpl implements KioskService{

    private final TakeReservationRepository takeReservationRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean checkReservation(KioskUserInput parameter) {

        Optional<Reservation> optionalReservation = takeReservationRepository.findByNameAndPhone(parameter.getName(), parameter.getPhone());

        if(!optionalReservation.isPresent()) {
            return false;
        }

        Reservation reservation = optionalReservation.get();
        reservation.setVisit(true);
        takeReservationRepository.save(reservation);

        Review review = Review.builder()
                .userId(reservation.getUserId())
                .name(reservation.getName())
                .phone(reservation.getPhone())
                .date(reservation.getDate())
                .restId(reservation.getId())
                .build();

        reviewRepository.save(review);

        return true;
    }
}
