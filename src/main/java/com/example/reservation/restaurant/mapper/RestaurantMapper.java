package com.example.reservation.restaurant.mapper;

import com.example.reservation.restaurant.dto.RestaurantDto;
import com.example.reservation.restaurant.model.RestaurantParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    List<RestaurantDto> selectList(RestaurantParam parameter);

}
