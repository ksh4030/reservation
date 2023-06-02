package com.example.reservation.restaurant.service;

import com.example.reservation.entity.Reservation;
import com.example.reservation.entity.Restaurant;
import com.example.reservation.partner.repository.PartnerRepository;
import com.example.reservation.restaurant.dto.RestaurantDto;
import com.example.reservation.restaurant.mapper.RestaurantMapper;
import com.example.reservation.restaurant.model.RestaurantInput;
import com.example.reservation.restaurant.model.RestaurantParam;
import com.example.reservation.restaurant.model.TakeRestaurantInput;
import com.example.reservation.restaurant.repository.RestaurantRepository;
import com.example.reservation.restaurant.repository.TakeReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService{

    private final PartnerRepository partnerRepository;
    private final RestaurantRepository restaurantRepository;
    private final TakeReservationRepository takeReservationRepository;

    private final RestaurantMapper restaurantMapper;

    @Override
    public boolean add(RestaurantInput parameter) {

        Restaurant restaurant = Restaurant.builder()
                .userId(parameter.getUserId())
                .name(parameter.getName())
                .location(parameter.getLocation())
                .content(parameter.getContent())
                .build();

        partnerRepository.save(restaurant);

        return true;
    }

    @Override
    public List<RestaurantDto> list(RestaurantParam parameter) {

        List<RestaurantDto> list = restaurantMapper.selectList(parameter);

        return list;
    }

    @Override
    public RestaurantDto detail(Long id) {

        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(!optionalRestaurant.isPresent()){
            return null;
        }

        Restaurant restaurant = optionalRestaurant.get();


        return RestaurantDto.of(restaurant);
    }

    @Override
    public ServiceResult req(TakeRestaurantInput parameter) {

        ServiceResult result = new ServiceResult();

        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(parameter.getRestaurantId());
        if(!optionalRestaurant.isPresent()) {
            result.setResult(false);
            result.setMessage("강좌 정보가 존재하지 않습니다.");
            return result;
        }

        Restaurant restaurant = optionalRestaurant.get();

        //이미 예약했는지 확인

        String[] statusList = {Reservation.STATUS_REQ, Reservation.STATUS_COMPLETE};
        long count = takeReservationRepository.countByRestIdAndUserIdAndStatusIn(restaurant.getId(), parameter.getUserId(), List.of(statusList));

        if(count > 0){
            result.setResult(false);
            result.setMessage("이미 예약했습니다.");
            return result;
        }

        Reservation reservation = Reservation.builder()
                .restId(restaurant.getId())
                .partnerId(restaurant.getUserId())
                .userId(parameter.getUserId())
                .date(parameter.getDate())
                .phone(parameter.getPhone())
                .name(parameter.getName())
                .status(Reservation.STATUS_REQ)
                .visit(false)
                .build();

        takeReservationRepository.save(reservation);

        result.setResult(true);
        result.setMessage("");
        return result;
    }

}
