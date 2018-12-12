package client.marker;

import client.user.UserModel;
import client.user.authentication.UserAuthenticationService;
import client.utils.ServiceSupport;
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
public class MarkerService {

    private final static String MARKER_BASE_URL = "http://localhost:8384/marker";

    private final static String OWNER_MAPPING = "/owner";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    public List<MarkerModel> getAllMarkers() throws URISyntaxException, IOException, HttpClientErrorException {
        URI uri = new URI(MARKER_BASE_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, MarkerModel.class));
    }

    public List<MarkerModel> getAllMarkersByOwner(Integer ownerId) throws URISyntaxException, IOException, HttpClientErrorException {
        URI uri = new URI(MARKER_BASE_URL + OWNER_MAPPING + StringConstants.SLASH +  ownerId.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + userAuthenticationService.getRawToken());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> data = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(data.getBody(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, MarkerModel.class));
    }

    public void addMarker(String name, String type, String description, String coordinate, UserModel user)
            throws JSONException, URISyntaxException, HttpClientErrorException {
        URI uri = new URI(MARKER_BASE_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        String monumentData = new JSONObject()
                .put("name", name)
                .put("type", type)
                .put("description", description)
                .put("coordinate",coordinate)
                .put("user", user)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(monumentData, headers);
        ResponseEntity<MarkerModel> response = restTemplate.exchange(uri, HttpMethod.POST, request, MarkerModel.class);
    }

    public void updateMarker(Integer markerId, String name, String type, String description, String coordinate, UserModel user)
            throws JSONException, URISyntaxException, HttpClientErrorException {
        URI uri = new URI(MARKER_BASE_URL + markerId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        String monumentData = new JSONObject()
                .put("name", name)
                .put("type", type)
                .put("description", description)
                .put("coordinate",coordinate)
                .put("user", user)
                .toString();
        HttpEntity<String> request = new HttpEntity<String>(monumentData, headers);
        ResponseEntity<MarkerModel> response = restTemplate.exchange(uri, HttpMethod.PUT, request, MarkerModel.class);
    }

    public void deleteMarker(Integer markerId) throws URISyntaxException {
        URI uri = new URI(MARKER_BASE_URL + StringConstants.SLASH +  markerId);
        ServiceSupport.requestDeleteByUri(uri, userAuthenticationService, restTemplate);
    }
}
