package client.utils;

import client.user.authentication.UserAuthenticationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public final class ServiceSupport {

    public static void requestDeleteByUri(URI uri, UserAuthenticationService userAuthenticationService, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+userAuthenticationService.getRawToken());
        HttpEntity<String> request = new HttpEntity<String>(headers);
        restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
    }

}
