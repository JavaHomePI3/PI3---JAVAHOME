package br.senac.sp.servlet.login.filter;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWTUtil {
    public static final String TAG_TOKEN = "Token: ";
    private static Key key;
    public static final String TOKEN_HEADER = "Authentication";
    public static final String TOKEN_USER_NAME = "user_name";
    public static final String TOKEN_AUTH = "userAuth";

    public static String create(String subject) {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String token = Jwts.builder()
                .setSubject(subject)
                .signWith(key)
                .compact();
        System.out.println(TAG_TOKEN + token);
        return token;
    }

    public static Jws<Claims> decode(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

    public static boolean verifyUser(String username, Jws<Claims> parse) throws JwtException {
        if (!username.isEmpty()) {
            if (parse.getBody().getSubject().equals(username)) {
                return true;
            }
        } else {
            System.out.println("O body do token não condis com o nome do usuário!");
            throw new JwtException("Token invalido");
        }
        return false;
    }
}
