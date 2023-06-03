package com.example.reservation.partner.service;

import com.example.reservation.entity.Reservation;
import com.example.reservation.restaurant.repository.RestaurantRepository;
import com.example.reservation.restaurant.repository.TakeReservationRepository;
import com.example.reservation.restaurant.service.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TakeReservationImpl implements TakeReservationService{

    private final TakeReservationRepository takeReservationRepository;

    //모든 예약 정보를 불러옴
    @Override
    public List<Reservation> list() {
        return takeReservationRepository.findAll();
    }

    //파트너가 예약을 수락/거절 함
    @Override
    public ServiceResult updateStatus(long id, String status) {

        Optional<Reservation> optionalReservation = takeReservationRepository.findById(id);
        if(!optionalReservation.isPresent()) {
            return new ServiceResult(false, "예약정보가 존재하지 않습니다.");
        }

        Reservation reservation = optionalReservation.get();
        reservation.setStatus(status);
        takeReservationRepository.save(reservation);

        return new ServiceResult(true);
    }
}
