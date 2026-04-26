package com.learning.spring_deep_dive.security.jwt;

import com.learning.spring_deep_dive.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${spring-deep-dive.jwtSecret}")
    private String jwtSecret;

    @Value("${spring-deep-dive.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
        return Jwts.builder()
                .subject(userDetail.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationInMs))
                .signWith(getSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    public SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build()
                .parseClaimsJws(token).getPayload().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
            return true;

        } catch (MalformedJwtException | ExpiredJwtException e) {
            System.out.println("Invalid JWT token" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Argument" + e.getMessage());
        }

        return false;
    }
}

