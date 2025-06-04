package com.queimazero.queimazeroAPI;

import com.queimazero.queimazeroAPI.models.Coordenadas;
import com.queimazero.queimazeroAPI.services.GeolocalizacaoService;

public class Main {
    public static void main(String[] args) {
        try {
            String endereco = "Avenida Matias Beck, 58";
            Coordenadas coordenadas = GeolocalizacaoService.geocode(endereco);

            if (coordenadas != null) {
                System.out.println("Endereço: " + endereco);
                System.out.println("Latitude: " + coordenadas.getLatitude());
                System.out.println("Longitude: " + coordenadas.getLongitude());
            } else {
                System.out.println("Endereço não encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao geocodificar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
