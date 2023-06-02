package com.example.reservation.restaurant.model;

import lombok.Data;

@Data
public class RestaurantParam {
    String searchType;
    String searchValue;

    String name;
    Long id;
}
