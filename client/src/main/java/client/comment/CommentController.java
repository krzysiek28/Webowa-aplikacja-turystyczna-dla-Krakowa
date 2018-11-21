package client.comment;

import client.user.authentication.UserAuthenticationService;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    private final UserAuthenticationService userAuthenticationService;

    private final CommentService commentService;

    public CommentController(UserAuthenticationService userAuthenticationService, CommentService commentService) {
        this.userAuthenticationService = userAuthenticationService;
        this.commentService = commentService;
    }

}
