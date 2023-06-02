package com.example.reservation.restaurant.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class TakeRestaurantInput {

    long restaurantId;
    String userId;
    LocalDateTime date;
    String name;
    String phone;
}
