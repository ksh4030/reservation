package com.example.reservation.restaurant.model;

import lombok.Data;

@Data
public class RestaurantInput {

    long id;
    String userId;
    String name;
    String location;
    String content;
}
