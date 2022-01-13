package com.gruntik.foodmatcher;

import com.gruntik.foodmatcher.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodMatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodMatcherApplication.class, args);
    }

}
