package com.queimazero.queimazeroAPI.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_ENDERECO_AGRICULTOR")
public class EnderecoAgricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco_agricultor")
    private Long idEnderecoAgricultor;

    @OneToOne(mappedBy = "enderecoAgricultor")
    private Agricultor agricultor;

    @Column(name = "rua_agricultor")
    private String ruaAgricultor;

    @Column(name = "numero_agricultor")
    private int numeroEnderecoAgricultor;

    @Column(name = "complemento_agricultor")
    private String complementoAgricultor;

    @Column(name = "latitude_agricultor", precision = 10, scale = 8)
    private BigDecimal latitudeAgricultor;

    @Column(name = "longitude_agricultor", precision = 11, scale = 8)
    private BigDecimal longitudeAgricultor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public Long getIdEnderecoAgricultor() {
        return idEnderecoAgricultor;
    }

    public void setIdEnderecoAgricultor(Long idEnderecoAgricultor) {
        this.idEnderecoAgricultor = idEnderecoAgricultor;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public String getRuaAgricultor() {
        return ruaAgricultor;
    }

    public void setRuaAgricultor(String ruaAgricultor) {
        this.ruaAgricultor = ruaAgricultor;
    }

    public int getNumeroEnderecoAgricultor() {
        return numeroEnderecoAgricultor;
    }

    public void setNumeroEnderecoAgricultor(int numeroAgricultor) {
        this.numeroEnderecoAgricultor = numeroAgricultor;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
