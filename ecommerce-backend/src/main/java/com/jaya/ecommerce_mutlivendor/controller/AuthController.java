package com.jaya.ecommerce_mutlivendor.controller;


import com.jaya.ecommerce_mutlivendor.modal.User;
import com.jaya.ecommerce_mutlivendor.repository.UserRepository;
import com.jaya.ecommerce_mutlivendor.response.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {



    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User>createUserHandler(@RequestBody SignUpRequest req) {

        User user = new User();
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
