package com.example.reservation.partner.repository;

import com.example.reservation.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Restaurant, Long> {
}
