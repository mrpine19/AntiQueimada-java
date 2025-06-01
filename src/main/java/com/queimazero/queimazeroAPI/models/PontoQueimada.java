package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_PONTOS_QUEIMADAS")
public class PontoQueimada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_queimada")
    private Long id;

    @Column(name = "data_queimada")
    private LocalDateTime dataQueimada;

    @Column(name = "intensidade", length = 20)
    private String intensidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @OneToMany(mappedBy = "pontoQueimada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaChatbot>  alertas;

    public PontoQueimada() {
    }

    public PontoQueimada(Long id, LocalDateTime dataQueimada, String intensidade, Municipio municipio, List<AlertaChatbot> alertas) {
        this.id = id;
        this.dataQueimada = dataQueimada;
        this.intensidade = intensidade;
        this.municipio = municipio;
        this.alertas = alertas;
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

    public String getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<AlertaChatbot> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaChatbot> alertas) {
        this.alertas = alertas;
    }
}
