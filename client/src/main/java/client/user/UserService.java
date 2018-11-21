package client.user;

import client.user.authentication.UserAuthenticationService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class UserService {

    private final static String USER_BASE_URL = "http://localhost:8384/users/";

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    RestTemplate restTemplate;

    public void login(String username, String password) throws URISyntaxException, HttpClientErrorException {
        URI uri = new URI("http://localhost:8384/login");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = "{\"username\": \"" + username + "\",\"password\": \"" + password + "\"}";
        HttpEntity<String> request = new HttpEntity<String>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        String key = response.getHeaders().get("Authorization").get(0).toString();
        userAuthenticationService.setToken(key);
    }

    public void logout() {
        userAuthenticationService.logout();
    }

    public UserModel getCurrentUser() throws URISyntaxException, HttpClientErrorException, IOException {
        String userName = userAuthenticationService.getUsername();
        URI uri = new URI(USER_BASE_URL + userName);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructType(UserModel.class));
    }

    public void register(String username, String password, String email) throws URISyntaxException, HttpClientErrorException, JSONException {
        URI uri = new URI(USER_BASE_URL + "sign-up");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = new JSONObject()
                .put("username", username)
                .put("password", password)
                .put("email", email)
                .put("enabled","true")
                .put("role", "USER_ROLE")
                .toString();

        HttpEntity<String> request = new HttpEntity<String>(requestJson, headers);

        ResponseEntity<Component> response = restTemplate.exchange(uri, HttpMethod.POST,request, Component.class);
        String key = response.getHeaders().get("Authorization").get(0).toString();
        userAuthenticationService.setToken(key);
    }

    public void deleteUser() throws URISyntaxException, JSONException {
        URI uri = new URI(USER_BASE_URL + userAuthenticationService.getUsername());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
        JSONObject obj = new JSONObject(response.getBody());
    }
}
