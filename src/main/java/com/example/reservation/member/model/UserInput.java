package com.example.reservation.member.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInput {

    String userId;
    String password;
    String name;
    String phone;
    boolean partnerYn;
    String regYn;

}
