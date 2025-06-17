package pe.edu.upeu.microservice_notification.infrastructure.config;

import feign.RequestInterceptor;

import feign.RequestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class KeycloakFeignInterceptor implements RequestInterceptor {
    private static final String TOKEN_URL = "http://localhost:8282/realms/ecommerce/protocol/openid-connect/token";
    private static final String CLIENT_ID = "backend-client";
    private static final String CLIENT_SECRET = "yo4FUA11RWp45kwBMjAeAipaZXKLmRxs";

    private String cachedToken = null;
    private long expirationTime = 0;

    @Override
    public void apply(RequestTemplate template) {
        String token = getToken();
        template.header("Authorization", "Bearer " + token);
    }

    private String getToken() {
        if (cachedToken != null && System.currentTimeMillis() < expirationTime) {
            return cachedToken;
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "grant_type=client_credentials"
                + "&client_id=" + CLIENT_ID
                + "&client_secret=" + CLIENT_SECRET;

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(TOKEN_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            cachedToken = (String) response.getBody().get("access_token");
            Integer expiresIn = (Integer) response.getBody().get("expires_in");
            expirationTime = System.currentTimeMillis() + (expiresIn - 30) * 1000; // resta 30s para estar seguros
            return cachedToken;
        }

        throw new RuntimeException("No se pudo obtener token de Keycloak");
    }
}
