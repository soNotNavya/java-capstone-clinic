package com.project.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class TokenService {

    // Secret key for signing the JWT
    private static final String SECRET = "my-super-secret-key-for-jwt-signing-which-should-be-long-enough";

    // Token validity: e.g., 24 hours
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    /**
     * Generates a JWT token using the provided email.
     */
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Returns the signing key using the configured secret.
     */
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
