package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_AGRICULTOR")
public class Agricultor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agricultor")
    private Long idAgricultor;

    @Column(name = "nome_agricultor")
    private String nomeAgricultor;

    @Column(name = "telefone_agricultor")
    private String telefoneAgricultor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @OneToMany(mappedBy = "agricultor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaChatbot> alertas;

    public Agricultor() {
    }

    public Agricultor(Long idAgricultor, String nomeAgricultor, String telefoneAgricultor, Municipio municipio) {
        this.idAgricultor = idAgricultor;
        this.nomeAgricultor = nomeAgricultor;
        this.telefoneAgricultor = telefoneAgricultor;
        this.municipio = municipio;
        alertas = new ArrayList<>();
    }

    public Long getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Long idAgricultor) {
        this.idAgricultor = idAgricultor;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
