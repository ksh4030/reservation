package com.example.reservation.review.service;

import com.example.reservation.entity.Review;
import com.example.reservation.kiosk.repository.ReviewRepository;
import com.example.reservation.member.model.UserInput;
import com.example.reservation.review.model.ReviewInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public boolean checkReview(String userId) {

        Optional<Review> optionalReview = reviewRepository.findByUserId(userId);
        return optionalReview.isPresent();
    }

    @Override
    public boolean registerReview(String userId, ReviewInput reviewInput) {

        Optional<Review> optionalReview = reviewRepository.findByUserId(userId);

        if(!optionalReview.isPresent()) {
            return false;
        }

        Review review = optionalReview.get();
        review.setComment(reviewInput.getComment());
        reviewRepository.save(review);

        return true;
    }
}
