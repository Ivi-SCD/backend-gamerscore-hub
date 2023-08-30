package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.exception.token.TokenErrorGenerationException;
import br.com.itcpn.gamescorehub.exception.token.TokenErrorInvalidOrExpiredException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("gamerscore-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new TokenErrorGenerationException("Error while generating token");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("gamerscore-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch(JWTVerificationException e) {
            throw new TokenErrorInvalidOrExpiredException("Invalid or expired Token JWT");
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
