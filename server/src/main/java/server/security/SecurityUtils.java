package server.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public final class SecurityUtils {
        public static final String SECRET = "SecretKeyToGenJWTs";
        public static final long EXPIRATION_TIME = 864_000_000; // 10 days
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";
        public static final String SIGN_UP_URL = "/users/sign-up";
        public static final String SIGN_IN_URL = "/users/sign-in";
        public static final String CLIENT_ADDRESS = "http://localhost:8383";


        public static String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                    .compact();
        }
}
