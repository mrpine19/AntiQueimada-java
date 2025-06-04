package com.queimazero.queimazeroAPI.models.dto;

import java.math.BigDecimal;

public class EnderecoAgricultorDTO {

    private Long idEndereco;
    private String agricultor;
    private String ruaAgricultor;
    private int numeroAgricultor;
    private String complementoAgricultor;
    private BigDecimal latitudeAgricultor;
    private BigDecimal longitudeAgricultor;
    private String municipio;

    public EnderecoAgricultorDTO(Long idEndereco, String agricultor, String ruaAgricultor, int numeroAgricultor, String complementoAgricultor, BigDecimal latitudeAgricultor, BigDecimal longitudeAgricultor, String municipio) {
        this.idEndereco = idEndereco;
        this.agricultor = agricultor;
        this.ruaAgricultor = ruaAgricultor;
        this.numeroAgricultor = numeroAgricultor;
        this.complementoAgricultor = complementoAgricultor;
        this.latitudeAgricultor = latitudeAgricultor;
        this.longitudeAgricultor = longitudeAgricultor;
        this.municipio = municipio;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(String agricultor) {
        this.agricultor = agricultor;
    }

    public String getRuaAgricultor() {
        return ruaAgricultor;
    }

    public void setRuaAgricultor(String ruaAgricultor) {
        this.ruaAgricultor = ruaAgricultor;
    }

    public int getNumeroAgricultor() {
        return numeroAgricultor;
    }

    public void setNumeroAgricultor(int numeroAgricultor) {
        this.numeroAgricultor = numeroAgricultor;
    }

    public String getComplementoAgricultor() {
        return complementoAgricultor;
    }

    public void setComplementoAgricultor(String complementoAgricultor) {
        this.complementoAgricultor = complementoAgricultor;
    }

    public BigDecimal getLatitudeAgricultor() {
        return latitudeAgricultor;
    }

    public void setLatitudeAgricultor(BigDecimal latitudeAgricultor) {
        this.latitudeAgricultor = latitudeAgricultor;
    }

    public BigDecimal getLongitudeAgricultor() {
        return longitudeAgricultor;
    }

    public void setLongitudeAgricultor(BigDecimal longitudeAgricultor) {
        this.longitudeAgricultor = longitudeAgricultor;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
