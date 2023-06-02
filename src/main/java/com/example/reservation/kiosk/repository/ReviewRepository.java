package com.example.reservation.kiosk.repository;

import com.example.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserId(String userId);

}
