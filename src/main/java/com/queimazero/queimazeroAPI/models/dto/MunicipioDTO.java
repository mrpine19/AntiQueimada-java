package com.queimazero.queimazeroAPI.models.dto;

public class MunicipioDTO {
    private String nomeMunicipio;
    private String ufMunicipio;

    public MunicipioDTO(String nomeMunicipio, String ufMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
        this.ufMunicipio = ufMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getUfMunicipio() {
        return ufMunicipio;
    }

    public void setUfMunicipio(String ufMunicipio) {
        this.ufMunicipio = ufMunicipio;
    }
}
