package com.example.reservation.review.service;

import com.example.reservation.member.model.UserInput;
import com.example.reservation.review.model.ReviewInput;

public interface ReviewService {

    boolean checkReview(String userId);

    boolean registerReview(String userId, ReviewInput reviewInput);

}
