package com.gruntik.foodmatcher;

import com.gruntik.foodmatcher.entity.Review;
import com.gruntik.foodmatcher.repository.UserTestRepository;
import com.gruntik.foodmatcher.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FoodMatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodMatcherApplication.class, args);
    }

}
