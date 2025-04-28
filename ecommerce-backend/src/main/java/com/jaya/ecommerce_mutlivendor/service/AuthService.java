package com.jaya.ecommerce_mutlivendor.service;

import com.jaya.ecommerce_mutlivendor.response.SignUpRequest;

public interface AuthService {

    String createUser(SignUpRequest signUpRequest);
}
