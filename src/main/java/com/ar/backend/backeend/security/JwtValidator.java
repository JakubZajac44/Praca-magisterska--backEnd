package com.ar.backend.backeend.security;

import com.ar.backend.backeend.model.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {


    private String secret = "youtube";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUsername(body.getSubject());
            jwtUser.setPassword((String)body.get("password"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}