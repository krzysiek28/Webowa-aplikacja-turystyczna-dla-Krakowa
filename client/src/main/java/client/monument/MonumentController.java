package client.monument;

import client.user.authentication.UserAuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MonumentController {

    private final UserAuthenticationService userAuthenticationService;

    private final MonumentService monumentService;

    public MonumentController(UserAuthenticationService userAuthenticationService, MonumentService monumentService) {
        this.userAuthenticationService = userAuthenticationService;
        this.monumentService = monumentService;
    }

    @RequestMapping(value = "/listPage")
    public String listPage(HttpServletRequest request,ModelMap modelMap) {
        try {
            modelMap.addAttribute("monuments", monumentService.getAllMonuments());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listPage";
    }
}
