package com.gruntik.foodmatcher.impl;

import com.gruntik.foodmatcher.entity.Review;
import com.gruntik.foodmatcher.model.ReviewModel;
import com.gruntik.foodmatcher.repository.ReviewRepository;
import com.gruntik.foodmatcher.services.ReviewService;
import com.gruntik.foodmatcher.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    FileUtils fileUtils;

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void save(ReviewModel reviewModel) {
        File file = fileUtils.multiPartFileToFile(reviewModel.getFile());

        reviewModel.setId(4L);
        reviewModel.setReviewDescription("diso");
        reviewModel.setReviewDate(new Date());

        Review review = new Review();
        review.setReviewTitle(reviewModel.getReviewTitle());
        review.setReviewDescription(reviewModel.getReviewDescription());
        review.setReviewDate(reviewModel.getReviewDate());
        review.setPhotoName(file.getName());
        review.setPhotoURL("/upload/"+file.getName());

        reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(new Review());
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
