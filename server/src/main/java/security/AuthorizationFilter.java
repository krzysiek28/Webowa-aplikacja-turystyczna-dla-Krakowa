package security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import user.UserEntity;
import user.UserRepository;

@Service
public class AuthorizationFilter {
    private final UserRepository appUserRepository;

    public AuthorizationFilter(UserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    private int getUserIdFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(SecurityUtils.SECRET.getBytes())
                .parseClaimsJws(token.replace(SecurityUtils.TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
        UserEntity user = appUserRepository.findByUsername(username);

        return user.getId();
    }

    public void isAuthorizedTo(String token, String resourceId, ResourceType resource) throws UnauthorizedException {
        int userId = getUserIdFromToken(token);
        switch(resource) {
            case USER:
                userAuth(userId, Integer.parseInt(resourceId));
                break;
            default:
                throw new IllegalArgumentException("Blad podczas autoryzacji!");
        }
    }

    private void userAuth(int userId, int requestUser) throws UnauthorizedException {
        UserEntity one = appUserRepository.findOne(requestUser);
        if ((one == null) || (!one.getId().equals(userId)))
            throw new UnauthorizedException("Brak pozwolenia!");
    }

}
