package com.gruntik.foodmatcher.repository;

import com.gruntik.foodmatcher.entity.Dish;
import com.gruntik.foodmatcher.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
