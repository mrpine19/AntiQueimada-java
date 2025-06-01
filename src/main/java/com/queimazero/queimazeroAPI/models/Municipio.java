package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MUNICIPIO")
public class Municipio {

    @Id
    @Column(name = "id_municipio")
    private Long idMunicipio;

    @Column(name = "nome_municipio")
    private String nomeMunicipio;

    @Column(name = "cidade_municipio")
    private String cidadeMunicipio;

    @Column(name = "uf_municipio")
    private String ufMunicipio;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agricultor> agricultoresMunicipio;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PontoQueimada> queimadas;

    public Municipio() {

    }

    public Municipio(Long idMunicipio, String nomeMunicipio, String cidadeMunicipio, String ufMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.cidadeMunicipio = cidadeMunicipio;
        this.ufMunicipio = ufMunicipio;
        this.agricultoresMunicipio = new ArrayList<Agricultor>();
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getCidadeMunicipio() {
        return cidadeMunicipio;
    }

    public void setCidadeMunicipio(String cidadeMunicipio) {
        this.cidadeMunicipio = cidadeMunicipio;
    }

    public String getUfMunicipio() {
        return ufMunicipio;
    }

    public void setUfMunicipio(String ufMunicipio) {
        this.ufMunicipio = ufMunicipio;
    }

    public List<Agricultor> getAgricultoresMunicipio() {
        return agricultoresMunicipio;
    }

    public void setAgricultoresMunicipio(List<Agricultor> agricultoresMunicipio) {
        this.agricultoresMunicipio = agricultoresMunicipio;
    }
}
