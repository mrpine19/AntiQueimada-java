package com.queimazero.queimazeroAPI.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PontoQueimadaDTO {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataQueimada;
    private String intensidadeQueimada;
    private String municipio;
    private BigDecimal latitudeQueimada;
    private BigDecimal longitudeQueimada;

    public PontoQueimadaDTO(LocalDateTime dataQueimada, String intensidadeQueimada, String municipio, BigDecimal latitudeQueimada, BigDecimal longitudeQueimada) {
        this.dataQueimada = dataQueimada;
        this.intensidadeQueimada = intensidadeQueimada;
        this.municipio = municipio;
        this.latitudeQueimada = latitudeQueimada;
        this.longitudeQueimada = longitudeQueimada;
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

    public BigDecimal getLatitudeQueimada() {
        return latitudeQueimada;
    }

    public void setLatitudeQueimada(BigDecimal latitudeQueimada) {
        this.latitudeQueimada = latitudeQueimada;
    }

    public BigDecimal getLongitudeQueimada() {
        return longitudeQueimada;
    }

    public void setLongitudeQueimada(BigDecimal longitudeQueimada) {
        this.longitudeQueimada = longitudeQueimada;
    }
}
