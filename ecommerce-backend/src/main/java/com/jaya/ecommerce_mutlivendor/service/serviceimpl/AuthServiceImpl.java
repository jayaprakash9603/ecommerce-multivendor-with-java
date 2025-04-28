package com.jaya.ecommerce_mutlivendor.service.serviceimpl;

import com.jaya.ecommerce_mutlivendor.repository.UserRepository;
import com.jaya.ecommerce_mutlivendor.response.SignUpRequest;
import com.jaya.ecommerce_mutlivendor.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    @Override
    public String createUser(SignUpRequest signUpRequest) {
        return "";
    }
}
