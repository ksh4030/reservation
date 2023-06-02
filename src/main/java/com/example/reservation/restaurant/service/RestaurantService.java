package com.example.reservation.restaurant.service;

import com.example.reservation.restaurant.dto.RestaurantDto;
import com.example.reservation.restaurant.model.RestaurantInput;
import com.example.reservation.restaurant.model.RestaurantParam;
import com.example.reservation.restaurant.model.TakeRestaurantInput;

import java.util.List;

public interface RestaurantService {


    boolean add(RestaurantInput parameter);

    List<RestaurantDto> list(RestaurantParam parameter);

    RestaurantDto detail(Long id);

    ServiceResult req(TakeRestaurantInput parameter);

}
