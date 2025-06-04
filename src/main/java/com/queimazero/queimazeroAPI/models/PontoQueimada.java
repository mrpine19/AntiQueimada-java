package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PONTOS_QUEIMADAS")
public class PontoQueimada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_queimada")
    private Long id;

    @Column(name = "data_queimada", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataQueimada;

    @Column(name = "intensidade", length = 20)
    private String intensidadeQueimada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @Column(name = "latitude_queimada", precision = 10, scale = 8)
    private BigDecimal latitudeQueimada;

    @Column(name = "longitude_agricultor", precision = 11, scale = 8)
    private BigDecimal longitudeQueimada;

    public PontoQueimada() {
    }

    public PontoQueimada(Long id, LocalDateTime dataQueimada, String intensidadeQueimada, Municipio municipio, BigDecimal latitudeQueimada, BigDecimal longitudeQueimada) {
        this.id = id;
        this.dataQueimada = dataQueimada;
        this.intensidadeQueimada = intensidadeQueimada;
        this.municipio = municipio;
        this.latitudeQueimada = latitudeQueimada;
        this.longitudeQueimada = longitudeQueimada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setIntensidadeQueimada(String intensidade) {
        this.intensidadeQueimada = intensidade;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
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
