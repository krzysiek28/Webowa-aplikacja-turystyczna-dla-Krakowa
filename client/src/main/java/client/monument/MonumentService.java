package client.monument;

import client.utils.ServiceSupport;
import client.user.authentication.UserAuthenticationService;
import client.utils.StringConstants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class MonumentService {

    private final static String MONUMENT_BASE_URL = "http://localhost:8384/monuments";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    public List<MonumentModel> getAllMonuments() throws URISyntaxException, IOException, HttpClientErrorException {
        URI uri = new URI(MONUMENT_BASE_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response.getBody(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, MonumentModel.class));
    }

    public void addMonument(String name, String kind, String description, String coordinate, Integer cost, String openingHours)
            throws JSONException, URISyntaxException, HttpClientErrorException {
        URI uri = new URI(MONUMENT_BASE_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        String monumentData = new JSONObject()
                .put("name",name)
                .put("kind",kind)
                .put("description", description)
                .put("coordinate",coordinate)
                .put("cost", cost)
                .put("openingHours", openingHours)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(monumentData, headers);
        ResponseEntity<MonumentModel> response = restTemplate.exchange(uri, HttpMethod.POST, request, MonumentModel.class);
    }

    public void updateMonument(Integer monumentId, String name, String kind, String description, String coordinate,
                               Integer cost, String openingHours) throws JSONException, URISyntaxException, HttpClientErrorException {
        URI uri = new URI(MONUMENT_BASE_URL + StringConstants.SLASH + monumentId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        String monumentData = new JSONObject()
                .put("name", name)
                .put("kind", kind)
                .put("description", description)
                .put("coordinate",coordinate)
                .put("cost", cost)
                .put("openingHours", openingHours)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(monumentData, headers);
        ResponseEntity<MonumentModel> response = restTemplate.exchange(uri, HttpMethod.PUT, request, MonumentModel.class);
    }

    public void deleteMonument(Integer monumentId) throws URISyntaxException {
        URI uri = new URI(MONUMENT_BASE_URL + StringConstants.SLASH + monumentId);
        ServiceSupport.requestDeleteByUri(uri, userAuthenticationService, restTemplate);
    }
}
