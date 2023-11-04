package br.com.yuri.padlipskas.Verzel.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.yuri.padlipskas.Verzel.models.Admin;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(Admin adm){
		try {
			Algorithm algoritmo = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("verzel")
					.withSubject(adm.getLogin())
					.withExpiresAt(generateExpirationDate())
					.sign(algoritmo);
			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar o token", e);
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algoritmo = Algorithm.HMAC256(secret);
			return JWT.require(algoritmo)
					.withIssuer("verzel")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
	}

}
