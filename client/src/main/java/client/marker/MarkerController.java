package client.marker;

import client.user.authentication.UserAuthenticationService;
import org.springframework.stereotype.Controller;

@Controller
public class MarkerController {

    private final UserAuthenticationService userAuthenticationService;

    private final MarkerService markerService;

    public MarkerController(UserAuthenticationService userAuthenticationService, MarkerService markerService) {
        this.userAuthenticationService = userAuthenticationService;
        this.markerService = markerService;
    }
}
