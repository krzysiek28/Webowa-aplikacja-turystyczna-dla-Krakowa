package server.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.security.AuthorizationFilter;
import server.security.ResourceType;
import server.security.UnauthorizedException;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    private final AuthorizationFilter authorizationFilter;

    public CommentController(CommentService commentService, AuthorizationFilter authorizationFilter) {
        this.commentService = commentService;
        this.authorizationFilter = authorizationFilter;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public void getAllCommentsByOwner(@PathVariable String userId, @RequestHeader("Authorization") String token) throws UnauthorizedException {
        authorizationFilter.isAuthorizedTo(token, userId, ResourceType.USER);
        commentService.getAllCommentsByOwner(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/monument/{monumentId}", method = RequestMethod.GET)
    public void getAllCommentsByMonument(@PathVariable String monumentId){
        commentService.getAllCommentsByMonument(Integer.parseInt(monumentId));
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
    public void getComment(@PathVariable String commentId){
        commentService.getComment(Integer.parseInt(commentId));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
    public void addComment(@RequestBody CommentEntity comment, @PathVariable String userId, @RequestHeader("Authorization") String token) throws UnauthorizedException {
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
