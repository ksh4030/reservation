package com.example.reservation.restaurant.dto;

import com.example.reservation.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    Long id;
    String name;
    String location;
    String content;
    double star;


    public static RestaurantDto of(Restaurant restaurant) {

        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .content(restaurant.getContent())
                .build();
    }
}
