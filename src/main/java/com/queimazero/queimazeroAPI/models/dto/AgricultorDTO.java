package com.queimazero.queimazeroAPI.models.dto;


public class AgricultorDTO {

    private String nomeAgricultor;
    private String telefoneAgricultor;
    private Long municipio;

    public AgricultorDTO() {
    }

    public AgricultorDTO(String nomeAgricultor, String telefoneAgricultor, Long municipio) {
        this.nomeAgricultor = nomeAgricultor;
        this.telefoneAgricultor = telefoneAgricultor;
        this.municipio = municipio;
    }

    public String getNomeAgricultor() {
        return nomeAgricultor;
    }

    public void setNomeAgricultor(String nomeAgricultor) {
        this.nomeAgricultor = nomeAgricultor;
    }

    public String getTelefoneAgricultor() {
        return telefoneAgricultor;
    }

    public void setTelefoneAgricultor(String telefoneAgricultor) {
        this.telefoneAgricultor = telefoneAgricultor;
    }

    public Long getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Long municipio) {
        this.municipio = municipio;
    }
}
