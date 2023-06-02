package com.example.reservation.partner.dto;

import java.time.LocalDateTime;

public class TakeReservationDto {

    long id;

    long restId;
    String partnerId;
    String userId;
    String name;
    String phone;

    LocalDateTime date;
    String status;

}
