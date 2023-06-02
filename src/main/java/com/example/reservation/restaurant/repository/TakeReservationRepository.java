package com.example.reservation.restaurant.repository;

import com.example.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface TakeReservationRepository extends JpaRepository<Reservation, Long> {

    long countByRestIdAndUserIdAndStatusIn(long restId, String userId, Collection<String> statusList);
    String findByUserId(String userId);

    Optional<Reservation> findByNameAndPhone(String name, String phone);

}
