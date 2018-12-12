package client.monument;

import client.user.authentication.UserAuthenticationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MonumentController {

    private final UserAuthenticationService userAuthenticationService;

    private final MonumentService monumentService;

    public MonumentController(UserAuthenticationService userAuthenticationService, MonumentService monumentService) {
        this.userAuthenticationService = userAuthenticationService;
        this.monumentService = monumentService;
    }

    @RequestMapping(value = "/listPage", method= RequestMethod.GET)
    public String listPage(HttpServletRequest request,ModelMap modelMap) throws JSONException {
        try {
            modelMap.addAttribute("monuments", monumentService.getAllMonuments());
        } catch (HttpServerErrorException exception) {
            JSONObject obj = new JSONObject(exception.getResponseBodyAsString());
            String errorMessage = obj.getString("message");
            System.out.println("moj message"+errorMessage);
            return "redirect:/listPage?error=" + errorMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listPage";
    }
}
