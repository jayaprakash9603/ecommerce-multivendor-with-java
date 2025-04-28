package com.jaya.ecommerce_mutlivendor.controller;


import com.jaya.ecommerce_mutlivendor.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @GetMapping
    public ApiResponse home() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to the E-commerce Multi-vendor application!");
        return apiResponse;
    }
}
