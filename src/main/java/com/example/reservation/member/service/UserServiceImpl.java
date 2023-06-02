package com.example.reservation.member.service;


import com.example.reservation.entity.User;
import com.example.reservation.member.model.UserInput;
import com.example.reservation.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public boolean register(UserInput parameter) {

        Optional<User> optionalUser = userRepository.findById(parameter.getUserId());
        if(optionalUser.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        User user = User.builder()
                .userId(parameter.getUserId())
                .password(encPassword)
                .name(parameter.getName())
                .phone(parameter.getPhone())
                .partnerYn(false)
                .build();

        userRepository.save(user);

        return true;
    }

    @Override
    public User find(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findById(username);
        if(!optionalUser.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        User user = optionalUser.get();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if(user.isPartnerYn()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_PARTNER"));
        }


        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), grantedAuthorities);
    }
}
