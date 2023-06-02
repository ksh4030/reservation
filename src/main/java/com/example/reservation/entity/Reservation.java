package com.example.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Reservation {
    public static String STATUS_REQ = "REQ";
    public static String STATUS_COMPLETE = "COMPLETE";
    public static String STATUS_CANCEL = "CANCEL";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    long restId;
    String partnerId;
    String userId;
    String name;
    String phone;

    LocalDateTime date;
    String status;
    boolean visit;

}
