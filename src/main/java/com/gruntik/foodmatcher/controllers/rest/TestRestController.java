package com.gruntik.foodmatcher.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/rest")
    public String getString() {
        return "hello igor rest";
    }
}
