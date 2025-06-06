package com.queimazero.queimazeroAPI.models.dto;


public class AgricultorDTO {

    private String nomeAgricultor;
    private String telefoneAgricultor;
    private String enderecoAgricultor;
    private String municipio;

    public AgricultorDTO() {
    }

    public AgricultorDTO(String nomeAgricultor, String telefoneAgricultor, String enderecoAgricultor, String municipio) {
        this.nomeAgricultor = nomeAgricultor;
        this.telefoneAgricultor = telefoneAgricultor;
        this.enderecoAgricultor = enderecoAgricultor;
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

    public String getEnderecoAgricultor() {
        return enderecoAgricultor;
    }

    public void setEnderecoAgricultor(String enderecoAgricultor) {
        this.enderecoAgricultor = enderecoAgricultor;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
