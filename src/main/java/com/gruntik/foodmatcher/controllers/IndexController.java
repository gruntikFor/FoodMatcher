package com.gruntik.foodmatcher.controllers;

import com.gruntik.foodmatcher.entity.UserTest;
import com.gruntik.foodmatcher.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    UserTestRepository userTestRepository;

    @GetMapping("/")
    public String getString(Model model) {

        UserTest returnUser = userTestRepository.findById(1L).get();


        UserTest userTest = new UserTest();
        userTest.setName("igor");

        userTestRepository.save(userTest);


        model.addAttribute("userTest", returnUser);
        return "index";
    }

}
