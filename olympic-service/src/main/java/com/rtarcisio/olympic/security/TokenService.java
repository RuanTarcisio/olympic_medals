package com.rtarcisio.olympic.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/*
DEVELOPED BY RUAN TARCISIO
 */
@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public DecodedJWT decodeTokenAndValid(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        try {
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token); // Decodifica e valida o token
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid token", e);
        }
    }

    public CustomUserDetails getUserDetails(String token) {
        DecodedJWT decodedJWT = decodeTokenAndValid(token);
        List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
        String username = decodedJWT.getClaim("nome").asString();
        return new CustomUserDetails(username, roles);
    }

    public String getClaim(String token, String claimName) {
        DecodedJWT decodedJWT = decodeTokenAndValid(token);
        return decodedJWT.getClaim(claimName).asString();
    }

    public List<String> getRoles(String token) {
        DecodedJWT decodedJWT = decodeTokenAndValid(token);
        return decodedJWT.getClaim("roles").asList(String.class);
    }

    public Date getExpirationDate(String token) {
        DecodedJWT decodedJWT = decodeTokenAndValid(token);
        return decodedJWT.getExpiresAt();
    }

}