package com.queimazero.queimazeroAPI.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.queimazero.queimazeroAPI.models.Coordenadas;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static java.util.Map.entry;

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
        JsonNode firstResult = rootNode.get(0);

        BigDecimal lat = new BigDecimal("0.0000");
        BigDecimal lon = new BigDecimal("0.0000");

        if (rootNode.size() != 0) {
            lat = new BigDecimal(firstResult.get("lat").asText());
            lon = new BigDecimal(firstResult.get("lon").asText());
        }


        return new Coordenadas(lat, lon);
    }

    public String buscarUFporMunicipio(String nomeMunicipio) throws Exception {
        // Passo 1: Obter coordenadas do município
        String geocodingUrl = "https://nominatim.openstreetmap.org/search?format=json&q=" +
                URLEncoder.encode(nomeMunicipio + ", Brasil", "UTF-8");

        HttpURLConnection conn = (HttpURLConnection) new URL(geocodingUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Your Application Name");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        JsonArray results = JsonParser.parseReader(in).getAsJsonArray();
        in.close();

        if (results.size() == 0) return "Não encontrado";

        JsonObject firstResult = results.get(0).getAsJsonObject();
        String lat = firstResult.get("lat").getAsString();
        String lon = firstResult.get("lon").getAsString();

        // Passo 2: Obter detalhes reversos (incluindo estado)
        String reverseUrl = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lon;

        conn = (HttpURLConnection) new URL(reverseUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Your Application Name");

        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        JsonObject addressDetails = JsonParser.parseReader(in).getAsJsonObject();
        in.close();

        // Extrair a sigla do estado corretamente
        String estadoCompleto = addressDetails.getAsJsonObject("address")
                .get("state").getAsString();

        // Mapear nomes completos para siglas
        return converterNomeEstadoParaSigla(estadoCompleto);
    }

    private String converterNomeEstadoParaSigla(String nomeEstado) {
        Map<String, String> estados = Map.ofEntries(
                entry("Acre", "AC"),
                entry("Alagoas", "AL"),
                entry("Amapá", "AP"),
                entry("Amazonas", "AM"),
                entry("Bahia", "BA"),
                entry("Ceará", "CE"),
                entry("Distrito Federal", "DF"),
                entry("Espírito Santo", "ES"),
                entry("Goiás", "GO"),
                entry("Maranhão", "MA"),
                entry("Mato Grosso", "MT"),
                entry("Mato Grosso do Sul", "MS"),
                entry("Minas Gerais", "MG"),
                entry("Pará", "PA"),
                entry("Paraíba", "PB"),
                entry("Paraná", "PR"),
                entry("Pernambuco", "PE"),
                entry("Piauí", "PI"),
                entry("Rio de Janeiro", "RJ"),
                entry("Rio Grande do Norte", "RN"),
                entry("Rio Grande do Sul", "RS"),
                entry("Rondônia", "RO"),
                entry("Roraima", "RR"),
                entry("Santa Catarina", "SC"),
                entry("São Paulo", "SP"),
                entry("Sergipe", "SE"),
                entry("Tocantins", "TO")
        );

        return estados.getOrDefault(nomeEstado, "Não encontrado");
    }
}
