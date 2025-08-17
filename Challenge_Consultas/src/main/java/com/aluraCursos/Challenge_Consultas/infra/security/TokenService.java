package com.aluraCursos.Challenge_Consultas.infra.security;

import com.aluraCursos.Challenge_Consultas.domain.Usuario.Usuario;
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

    @Value("${Challenge_Consultas.security.token.secret}")
    private String secret;

    public String generarToken(Usuario usuario){
        try {
           var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("com.aluraCursos.Challenge_Consultas")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
         throw  new RuntimeException("error al generar el token JWT", exception);
        }

    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }
    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("com.aluraCursos.Challenge_Consultas")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
             throw new RuntimeException("Token JWT invalido o expirado!");
        }

    }
}
