package br.senac.sp.token.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWTUtil {
    private static Key key;

    public static final String TOKEN_HEADER = "Authentication";

    public static String create(String subject) {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String token =  Jwts.builder()
                .setSubject(subject)
                .signWith(key)
                .compact();
        System.out.println("Token: "+token);
        return token;
    }

    public static Jws<Claims> decode(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}
