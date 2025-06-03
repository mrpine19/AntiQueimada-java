package com.queimazero.queimazeroAPI.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PontoQueimadaDTO {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataQueimada;
    private String intensidadeQueimada;
    private String municipio;

    public PontoQueimadaDTO(LocalDateTime dataQueimada, String intensidadeQueimada, String municipio) {
        this.dataQueimada = dataQueimada;
        this.intensidadeQueimada = intensidadeQueimada;
        this.municipio = municipio;
    }

    public LocalDateTime getDataQueimada() {
        return dataQueimada;
    }

    public void setDataQueimada(LocalDateTime dataQueimada) {
        this.dataQueimada = dataQueimada;
    }

    public String getIntensidadeQueimada() {
        return intensidadeQueimada;
    }

    public void setIntensidadeQueimada(String intensidadeQueimada) {
        this.intensidadeQueimada = intensidadeQueimada;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
