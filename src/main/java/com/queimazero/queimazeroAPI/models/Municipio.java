package com.queimazero.queimazeroAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_MUNICIPIO")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio", unique = true, nullable = false)
    private Long idMunicipio;

    @Column(name = "nome_municipio", unique = true)
    private String nomeMunicipio;

    @Column(name = "uf_municipio")
    private String ufMunicipio;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnderecoAgricultor> enderecosAgricultor;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PontoQueimada> queimadas;

    public Municipio() {

    }

    public Municipio(Long idMunicipio, String nomeMunicipio, String cidadeMunicipio, String ufMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.ufMunicipio = ufMunicipio;
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

    public String getUfMunicipio() {
        return ufMunicipio;
    }

    public void setUfMunicipio(String ufMunicipio) {
        this.ufMunicipio = ufMunicipio;
    }

    public List<EnderecoAgricultor> getEnderecosAgricultor() {
        return enderecosAgricultor;
    }

    public void setEnderecosAgricultor(List<EnderecoAgricultor> enderecosAgricultor) {
        this.enderecosAgricultor = enderecosAgricultor;
    }

    public List<PontoQueimada> getQueimadas() {
        return queimadas;
    }

    public void setQueimadas(List<PontoQueimada> queimadas) {
        this.queimadas = queimadas;
    }
}
