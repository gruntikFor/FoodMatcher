package com.gruntik.foodmatcher.controllers;

import com.gruntik.foodmatcher.model.ReviewModel;
import com.gruntik.foodmatcher.repository.UserTestRepository;
import com.gruntik.foodmatcher.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    UserTestRepository userTestRepository;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/")
    public String getString(Model model) {
        return "index";
    }

    @GetMapping("/review-form")
    public String reviewFormPage(@ModelAttribute("reviewModel") ReviewModel reviewModel, Model model) {

//        Review review = new Review();
//
//        review.setId(1L);
//        review.setReviewTitle("Amazing!");
//        review.setPhotoName("dish1.png");
//        review.setPhotoURL("/upload/");
//        review.setReviewDate(new Date());
//
//        reviewService.save(review);

        model.addAttribute("review", reviewService.findById(1L));


        return "review-form";
    }

    @PostMapping("/review-form")
    public String reviewFormSend(@ModelAttribute("reviewModel") ReviewModel reviewModel) {

        System.out.println(reviewModel);
        reviewService.save(reviewModel);
        return "index";
    }

}
