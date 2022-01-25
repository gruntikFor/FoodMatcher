package com.gruntik.foodmatcher.services;

import com.gruntik.foodmatcher.entity.Review;
import com.gruntik.foodmatcher.model.ReviewModel;


public interface ReviewService {

    void save(Review review);

    void save(ReviewModel reviewModel);

    Review findById(Long id);

    void deleteById(Long id);
}
