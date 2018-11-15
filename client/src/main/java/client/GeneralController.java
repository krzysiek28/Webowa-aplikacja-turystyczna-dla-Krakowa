package client;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class GeneralController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String initialPage(){
        return "initialPage";
    }

    @ExceptionHandler({ HttpServerErrorException.class})
    public String handleException(HttpServerErrorException ex) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(ex.getResponseBodyAsString());
            String errorMessage = obj.getString("message");
            return "redirect:/homePage?error="+errorMessage;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return"redirect:/homePage?error=Nieoczekiwany błąd!";
    }
}
