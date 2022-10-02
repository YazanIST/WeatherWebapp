package com.atypon.show_results;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthenticationService {
    private boolean isAuthenticated = false;

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticationStatus(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void validate(User user) {
        String url = "http://authenticationservice:4444/check";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject userJsonObject = new JSONObject();
        userJsonObject.put("username", user.getUsername());
        userJsonObject.put("password", user.getPassword());
        HttpEntity<String> request = new HttpEntity<String>(userJsonObject.toString(), headers);
        String personResultAsJsonStr = restTemplate.postForObject(url, request, String.class);
        setAuthenticationStatus(restTemplate.postForObject(url, request, String.class).equals("true"));
    }
}
