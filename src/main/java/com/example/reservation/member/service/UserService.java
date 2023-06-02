package com.example.reservation.member.service;

import com.example.reservation.entity.User;
import com.example.reservation.member.model.UserInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean register(UserInput parameter);

    User find(String userId);
}
