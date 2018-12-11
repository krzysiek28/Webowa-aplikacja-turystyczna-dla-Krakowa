package client.comment;

import client.monument.MonumentModel;
import client.user.UserModel;
import client.user.authentication.UserAuthenticationService;
import client.utils.ClientStore;
import client.utils.ServiceSupport;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class CommentService {

    private final static String COMMENT_BASE_URL = "http://localhost:8384/comments/";

    private final static String USER_MAPPING = "user/";

    private final static String MONUMENT_MAPPING = "monument/";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    public List<CommentModel> getCommentsByUser() throws URISyntaxException, IOException {
        String userName = userAuthenticationService.getUsername();
        URI uri = new URI(COMMENT_BASE_URL + USER_MAPPING + userName);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, CommentModel.class));
    }

    public void addComment(MonumentModel monument, Integer rate, String description) throws URISyntaxException, JSONException {
        String userName = userAuthenticationService.getUsername();
        URI uri = new URI(COMMENT_BASE_URL + USER_MAPPING + userName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + userAuthenticationService.getRawToken());
        UserModel user = ClientStore.getCurrentUser();
        String commentData = new JSONObject()
                .put("user", user)
                .put("monument", monument)
                .put("rate", rate)
                .put("description", description)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(commentData, headers);
        ResponseEntity<CommentModel> response = restTemplate.exchange(uri, HttpMethod.POST, request, CommentModel.class);
    }

    public List<CommentModel> getCommentsByMonument(Integer monumentId) throws URISyntaxException, IOException {
        URI uri = new URI(COMMENT_BASE_URL + MONUMENT_MAPPING + monumentId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, CommentModel.class));
    }

    public CommentModel getCommentById(Integer commentId) throws URISyntaxException, IOException {
        URI uri = new URI(COMMENT_BASE_URL + commentId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructType(CommentModel.class));
    }

    public void updateComment(Integer commentId, MonumentModel monument, Integer rate, String description) throws URISyntaxException, JSONException {
        URI uri = new URI(COMMENT_BASE_URL + commentId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        UserModel user = ClientStore.getCurrentUser();
        String commentData = new JSONObject()
                .put("user", user)
                .put("monument", monument)
                .put("rate", rate)
                .put("description", description)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(commentData, headers);
        ResponseEntity<CommentModel> response = restTemplate.exchange(uri, HttpMethod.PUT, request, CommentModel.class);
    }

    public void deleteComment(Integer commentId) throws URISyntaxException {
        URI uri = new URI(COMMENT_BASE_URL + commentId);
        ServiceSupport.requestDeleteByUri(uri, userAuthenticationService, restTemplate);
    }
}
