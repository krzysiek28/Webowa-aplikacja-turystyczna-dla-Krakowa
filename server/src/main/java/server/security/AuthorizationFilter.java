package server.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import server.comment.CommentEntity;
import server.comment.CommentRepository;
import server.user.UserEntity;
import server.user.UserRepository;

@Service
public class AuthorizationFilter {

    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    public AuthorizationFilter(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    private int getUserIdFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(SecurityUtils.SECRET.getBytes())
                .parseClaimsJws(token.replace(SecurityUtils.TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
        UserEntity user = userRepository.findByUsername(username);

        return user.getId();
    }

    public void isAuthorizedTo(String token, String resourceId, ResourceType resource) throws UnauthorizedException {
        int userId = getUserIdFromToken(token);
        switch(resource) {
            case USER:
                userAuth(userId, Integer.parseInt(resourceId));
                break;
            case COMMENT:
                commentAuth(userId, Integer.parseInt(resourceId));
                break;
            case MONUMENT:
                monumentAuth(userId, Integer.parseInt(resourceId));
                break;
            default:
                throw new IllegalArgumentException("Blad podczas autoryzacji!");
        }
    }

    private void userAuth(int userId, int requestUser) throws UnauthorizedException {
        UserEntity one = userRepository.findOne(requestUser);
        if ((one == null) || (!one.getId().equals(userId))) {
            throw new UnauthorizedException("Brak pozwolenia!");
        }
    }

    private void commentAuth(int userId, int requestComment) throws UnauthorizedException {
        CommentEntity one = commentRepository.findOne(requestComment);
        if ((one == null) || (!one.getUser().getId().equals(userId))){
            throw new UnauthorizedException("Brak pozwolenia!");
        }
    }

    private void monumentAuth(int userId, int requestComment) throws UnauthorizedException {
        //do nothing, in the future auth by userRole
    }

}
