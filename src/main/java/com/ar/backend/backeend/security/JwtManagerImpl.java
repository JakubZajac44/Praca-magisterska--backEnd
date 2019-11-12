package com.ar.backend.backeend.security;

import com.ar.backend.backeend.model.security.JwtUser;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@Component
public class JwtManagerImpl implements JwtManager{
    @Override
    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
        claims.put("password",jwtUser.getPassword());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
