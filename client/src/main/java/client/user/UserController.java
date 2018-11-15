package client.user;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.URISyntaxException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //TODO fixIt
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loggedPage(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             SessionStatus status) throws URISyntaxException, JSONException {
        try {
            userService.login(username, password);
            status.setComplete();
        } catch (HttpStatusCodeException exception) {
            JSONObject obj = new JSONObject(exception.getResponseBodyAsString());
            String errorMessage = obj.getString("message");
            return "redirect:/loginPage?error=badcredentials&message=" + errorMessage; //fill

        }
        return "redirect:/"; //fill
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           SessionStatus status) throws URISyntaxException, JSONException {
        try {
            userService.register(username, password, email);
            status.setComplete();
        } catch (HttpStatusCodeException e) {
            JSONObject obj = new JSONObject(e.getResponseBodyAsString());
            String errorMessage = obj.getString("message");
            String errorType;
            switch (errorMessage) {
                case "Username already exists!":
                    errorType = "username";
                    break;
                case "User with provided email already exists!":
                    errorType = "email";
                    break;
                default:
                    errorType = errorMessage;
                    break;
            }
            return "redirect:/registrationPage?error=yes&message=" + errorType;
        }
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") String userId) throws URISyntaxException, JSONException {
        try {
            userService.deleteUser();
        } catch (HttpServerErrorException exception) {
            JSONObject obj = new JSONObject(exception.getResponseBodyAsString());
            String errorMessage = obj.getString("message");
            return "redirect:/homePage?error=" + errorMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
