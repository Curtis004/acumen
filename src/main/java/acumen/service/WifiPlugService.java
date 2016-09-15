package acumen.service;

import acumen.domain.acumen.Intent;
import acumen.domain.wifiplug.Token;
import com.google.gson.Gson;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class WifiPlugService {
    private Gson gson = new Gson();

    private Environment environment;

    private RestTemplate restTemplate;

    private Token token;

    public WifiPlugService(Environment environment, RestTemplate restTemplate) {
        this.environment = environment;
        this.restTemplate = restTemplate;

        this.token = getToken();
    }

    public boolean process(Intent intent) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("token", token.toString());
        params.add("device_id", intent.getDevice().getDeviceId());
        params.add("on", String.valueOf(intent.getState().toBoolean()));

        String response = restTemplate.postForObject(getBaseUrl() + "/device_control", params, String.class);

        return true;
    }

    private Token getToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", environment.getProperty("wifiplug.username"));
        params.add("password", environment.getProperty("wifiplug.password"));

        // We have to do this as the wifiplug API doesn't return the correct Content-Type.
        String response = restTemplate.postForObject(getBaseUrl() + "/user_login", params, String.class);
        return gson.fromJson(response, Token.class);
    }

    private String getBaseUrl() {
        return environment.getProperty("wifiplug.host");
    }
}
