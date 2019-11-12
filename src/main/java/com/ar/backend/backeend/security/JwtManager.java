package com.ar.backend.backeend.security;

import com.ar.backend.backeend.model.security.JwtUser;

public interface JwtManager {

    String generate(JwtUser jwtUser);
}
