package com.jaya.ecommerce_mutlivendor.service.serviceimpl;

import com.jaya.ecommerce_mutlivendor.config.JwtProvider;
import com.jaya.ecommerce_mutlivendor.domain.USER_ROLE;
import com.jaya.ecommerce_mutlivendor.modal.Cart;
import com.jaya.ecommerce_mutlivendor.modal.User;
import com.jaya.ecommerce_mutlivendor.repository.CartRepository;
import com.jaya.ecommerce_mutlivendor.repository.UserRepository;
import com.jaya.ecommerce_mutlivendor.response.SignUpRequest;
import com.jaya.ecommerce_mutlivendor.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final JwtProvider jwtProvider;
    @Override
    public String createUser(SignUpRequest req) {

    User user =userRepository.findByEmail(req.getEmail());
    if(user==null)
    {
        User createdUser = new User();
        createdUser.setEmail(req.getEmail());
        createdUser.setFullName(req.getFullName());
        createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
        createdUser.setMobile("234234");
        createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
        user=userRepository.save(createdUser);

        Cart cart= new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }

        List<GrantedAuthority>authorities=new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));
        Authentication authentication=new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return JwtProvider.generateToken(authentication);
    }
}
