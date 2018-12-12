package client.user.authentication;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class SignController {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage(ModelMap model, SessionStatus status) {
        model.addAttribute("authservice", userAuthenticationService);
        status.setComplete();
        return "loginPage";
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String registrationPage() {
        return "registrationPage";
    }

    @RequestMapping(value = "/homePage")
    public String homePage(ModelMap model) throws URISyntaxException, JSONException, IOException {
        model.addAttribute("authservice", userAuthenticationService);
        return "homePage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        userAuthenticationService.logout();
        return "redirect:/";
    }
}
