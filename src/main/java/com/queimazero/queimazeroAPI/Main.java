package com.queimazero.queimazeroAPI;

import com.queimazero.queimazeroAPI.models.Coordenadas;
import com.queimazero.queimazeroAPI.services.GeolocalizacaoService;

public class Main {
    public static void main(String[] args) {
        GeolocalizacaoService service = new GeolocalizacaoService();

        try {
            Coordenadas location = service.obterCoordenadas("Avenida Matias Beck");
            System.out.println("Latitude: " + location.getLatitude());
            System.out.println("Longitude: " + location.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
