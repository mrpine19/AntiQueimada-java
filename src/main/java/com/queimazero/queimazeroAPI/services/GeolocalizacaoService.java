package com.queimazero.queimazeroAPI.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.queimazero.queimazeroAPI.models.Coordenadas;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GeolocalizacaoService {
    private static final String API_URL = "https://nominatim.openstreetmap.org/search?format=json&q=";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Coordenadas obterCoordenadas(String address) throws IOException, InterruptedException {
        String encodedAddress = java.net.URLEncoder.encode(address, "UTF-8");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + encodedAddress))
                .header("User-Agent", "Your Application Name")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro na requisição: " + response.statusCode());
        }

        // Usar JsonNode para navegar no JSON
        JsonNode rootNode = objectMapper.readTree(response.body());
        if (rootNode.size() == 0) {
            throw new IOException("Nenhum resultado encontrado para o endereço fornecido");
        }

        JsonNode firstResult = rootNode.get(0);
        BigDecimal lat = new BigDecimal(firstResult.get("lat").asText());
        BigDecimal lon = new BigDecimal(firstResult.get("lon").asText());

        return new Coordenadas(lat, lon);
    }
}
