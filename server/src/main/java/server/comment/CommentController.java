package server.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import server.security.AuthorizationFilter;
import server.security.ResourceType;
import server.security.UnauthorizedException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    private final AuthorizationFilter authorizationFilter;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CommentController(CommentService commentService, AuthorizationFilter authorizationFilter) {
        this.commentService = commentService;
        this.authorizationFilter = authorizationFilter;
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public List<CommentEntity> getAllCommentsByOwner(@PathVariable String userName, @RequestHeader("Authorization") String token) throws UnauthorizedException {
        String userId = jdbcTemplate.queryForObject("SELECT id from users where username=" + "\'" + userName + "\'" + ";", String.class);
        authorizationFilter.isAuthorizedTo(token, userId, ResourceType.USER);
        return commentService.getAllCommentsByOwner(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/monument/{monumentId}", method = RequestMethod.GET)
    public List<CommentEntity> getAllCommentsByMonument(@PathVariable String monumentId, @RequestHeader("Authorization") String token){
        return commentService.getAllCommentsByMonument(Integer.parseInt(monumentId));
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
    public CommentEntity getComment(@PathVariable String commentId, @RequestHeader("Authorization") String token) {
        return commentService.getComment(Integer.parseInt(commentId));
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.POST)
    public void addComment(@RequestBody CommentEntity comment, @PathVariable String userName, @RequestHeader("Authorization") String token) throws UnauthorizedException {
        String userId = jdbcTemplate.queryForObject("SELECT id from users where username=" + "\'" + userName + "\'" + ";", String.class);
        authorizationFilter.isAuthorizedTo(token, userId, ResourceType.USER);
        commentService.addComment(comment);
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody CommentEntity comment, @PathVariable String commentId, @RequestHeader("Authorization") String token) throws UnauthorizedException {
        authorizationFilter.isAuthorizedTo(token, commentId, ResourceType.COMMENT);
        commentService.updateComment(Integer.parseInt(commentId), comment);
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable String commentId, @RequestHeader("Authorization") String token) throws UnauthorizedException {
        authorizationFilter.isAuthorizedTo(token, commentId, ResourceType.COMMENT);
        commentService.deleteComment(Integer.parseInt(commentId));
    }
}
