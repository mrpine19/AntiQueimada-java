package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALERTA_CHATBOT")
public class AlertaChatbot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "mensagem_alerta", length = 200)
    private String mensagem;

    @Column(name = "alerta_enviado", length = 1)
    private Character alertaEnviado;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agricultor", nullable = false)
    private Agricultor agricultor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_queimada", nullable = false)
    private PontoQueimada pontoQueimada;

    public AlertaChatbot() {
    }

    public AlertaChatbot(Long id, String mensagem, Character alertaEnviado, LocalDateTime dataEnvio, Agricultor agricultor, PontoQueimada pontoQueimada) {
        this.id = id;
        this.mensagem = mensagem;
        this.alertaEnviado = alertaEnviado;
        this.dataEnvio = dataEnvio;
        this.agricultor = agricultor;
        this.pontoQueimada = pontoQueimada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}