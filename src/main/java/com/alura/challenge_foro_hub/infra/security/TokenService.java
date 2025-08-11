package com.alura.challenge_foro_hub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(String correoElectronico) {
        Instant exp = Instant.now().plus(2, ChronoUnit.HOURS); // +2h UTC
        String token = JWT.create()
                .withSubject(correoElectronico)
                .withIssuer("ForoHub API")
                .withExpiresAt(exp)
                .sign(Algorithm.HMAC256(apiSecret));

        System.out.println("🎫 Token emitido para " + correoElectronico + " exp=" + exp);
        return token;
    }

    public String getSubject(String tokenJWT) {
        try {
            var verifier = JWT.require(Algorithm.HMAC256(apiSecret))
                    .withIssuer("ForoHub API")
                    .acceptLeeway(60)       // tolerancia de 60s
                    .build();

            var decoded = verifier.verify(tokenJWT);
            return decoded.getSubject();

        } catch (TokenExpiredException e) {
            throw new IllegalArgumentException("Token expirado", e);
        } catch (JWTVerificationException e) {
            throw new IllegalArgumentException("Firma/issuer inválidos", e);
        }
    }
}