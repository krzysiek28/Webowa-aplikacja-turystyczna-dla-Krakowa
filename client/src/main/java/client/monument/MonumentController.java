package client.monument;

import client.user.authentication.UserAuthenticationService;
import org.springframework.stereotype.Controller;

@Controller
public class MonumentController {

    private final UserAuthenticationService userAuthenticationService;

    private final MonumentService monumentService;

    public MonumentController(UserAuthenticationService userAuthenticationService, MonumentService monumentService) {
        this.userAuthenticationService = userAuthenticationService;
        this.monumentService = monumentService;
    }


}
