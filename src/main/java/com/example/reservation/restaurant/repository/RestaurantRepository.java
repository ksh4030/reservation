package com.example.reservation.restaurant.repository;

import com.example.reservation.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    String findByUserId(String userId);

}
