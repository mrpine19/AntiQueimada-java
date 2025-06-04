package com.queimazero.queimazeroAPI.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.queimazero.queimazeroAPI.models.Coordenadas;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class GeolocalizacaoService {
    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Coordenadas geocode(String endereco) throws Exception {
        String query = URLEncoder.encode(endereco, StandardCharsets.UTF_8);
        String url = String.format("%s?format=json&q=%s", NOMINATIM_URL, query);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "JavaNominatimClient/1.0")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonNode rootNode = objectMapper.readTree(response.body());
            if (rootNode.isArray() && rootNode.size() > 0) {
                JsonNode primeiroResultado = rootNode.get(0);
                BigDecimal lat = primeiroResultado.get("lat").decimalValue();
                BigDecimal lon = primeiroResultado.get("lon").decimalValue();
                return new Coordenadas(lat, lon);
            }
        } else {
            throw new RuntimeException("Erro na requisição: " + response.statusCode());
        }
        return null;
    }
}
