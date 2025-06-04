package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALERTA")
public class Alerta {

    @Id
    @Column(name = "id_alerta")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agricultor", nullable = false)
    private Agricultor agricultor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_queimada", nullable = false)
    private PontoQueimada pontoQueimada;

    @Column(name = "mensagem_alerta", length = 200)
    private String mensagem;

    @Column(name = "alerta_enviado", length = 1)
    private Character alertaEnviado;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    public Alerta() {
    }

    public Alerta(String mensagem, PontoQueimada pontoQueimada, Agricultor agricultor) {
        this.mensagem = mensagem;
        this.pontoQueimada = pontoQueimada;
        this.agricultor = agricultor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public PontoQueimada getPontoQueimada() {
        return pontoQueimada;
    }

    public void setPontoQueimada(PontoQueimada pontoQueimada) {
        this.pontoQueimada = pontoQueimada;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Character getAlertaEnviado() {
        return alertaEnviado;
    }

    public void setAlertaEnviado(Character alertaEnviado) {
        this.alertaEnviado = alertaEnviado;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}