package com.example.reservation.partner.service;

import com.example.reservation.entity.Reservation;
import com.example.reservation.restaurant.service.ServiceResult;

import java.util.List;

public interface TakeReservationService {

    List<Reservation> list();

    ServiceResult updateStatus(long id, String status);

}
