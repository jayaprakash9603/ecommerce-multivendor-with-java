package com.jaya.ecommerce_mutlivendor.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtProvider {

    private static SecretKey key = Keys.hmacShaKeyFor(JWT_CONSTANT.SECRET_KEY.getBytes());


    public static String generateToken(Authentication auth) {

        Collection<? extends GrantedAuthority> authorities=auth.getAuthorities();
        String roles=populateAuthorities(authorities);
        String jwt = Jwts.builder()
                .setIssuer("Jayaprakash")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 86400000))  // 1 day expiration
                .claim("email", auth.getName())
                .claim("authorities",roles)
                .signWith(key)
                .compact();
        return jwt;
    }

    private static String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Set<String>auths=new HashSet<>();
        for (GrantedAuthority authority : authorities) {
            auths.add(authority.getAuthority());
        }

        return String.join(",",auths);
    }

    public static String getEmailFromJwtToken(String jwt)
    {
        jwt=jwt.substring(7);

        Claims claims=Jwts.parserBuilder()
                .setSigningKey(key).build().parseClaimsJws(jwt).getBody();


        String email=String.valueOf(claims.get("email"));
        return email;
    }
}
