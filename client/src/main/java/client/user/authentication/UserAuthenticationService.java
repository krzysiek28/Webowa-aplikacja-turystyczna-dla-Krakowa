package client.user.authentication;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class UserAuthenticationService {
    private String rawToken = null;
    private String username;
    private Integer userId;

    public void setToken(String token) {
        this.rawToken = token.replaceFirst("Bearer ", "");

        final String[] user = new String[1];

        SigningKeyResolver signingKeyResolver = new SigningKeyResolverAdapter() {
            @Override
            public Key resolveSigningKey(JwsHeader header, Claims claims) {
                user[0] = claims.getSubject();
                return null;
            }
        };

        try {
            Jwts.parser()
                    .setSigningKeyResolver(signingKeyResolver)
                    .parseClaimsJws(rawToken)
                    .getBody();
        } catch (Exception e) {}
        //TODO verify type of user content
        this.username = user[0];
        this.userId = Integer.parseInt(user[0]);
    }

    public String getUsername() {
        return this.username;
    }

    public Boolean isLoggedIn() {
        return rawToken != null;
    }

    public void logout() {
        this.username = null;
        this.rawToken = null;
    }

    public String getRawToken() {
        return this.rawToken;
    }

    public void setUserId(Integer userId){ this.userId=userId; }

    public Integer getUserId(){ return this.userId; }
}