package com.kaique.crm.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Base64;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration-minutes}")
    private long expirationMinutes;

    private Key key() {
        byte[] decodedKey = java.util.Base64.getDecoder().decode(secret);
        System.out.println("JWT SECRET bytes = " + decodedKey.length);
        return io.jsonwebtoken.security.Keys.hmacShaKeyFor(decodedKey);
    }

    public String generateToken(String subject) {
        long now = System.currentTimeMillis();
        long exp = now + (expirationMinutes * 60_000);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(exp))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getSubject(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
