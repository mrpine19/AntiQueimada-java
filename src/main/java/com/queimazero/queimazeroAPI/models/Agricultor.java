package com.queimazero.queimazeroAPI.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

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

    @Column(name = "data_horario_cadastro")
    private String dataHorarioCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_agricultor")
    private EnderecoAgricultor enderecoAgricultor;

    public Agricultor() {
    }

    public Agricultor(Long idAgricultor, String nomeAgricultor, String telefoneAgricultor, EnderecoAgricultor enderecoAgricultor) {
        this.idAgricultor = idAgricultor;
        this.nomeAgricultor = nomeAgricultor;
        this.telefoneAgricultor = telefoneAgricultor;
        this.enderecoAgricultor = enderecoAgricultor;
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

    public EnderecoAgricultor getEnderecoAgricultor() {
        return enderecoAgricultor;
    }

    public void setEnderecoAgricultor(EnderecoAgricultor enderecoAgricultor) {
        this.enderecoAgricultor = enderecoAgricultor;
    }

    public String getDataHorarioCadastro() {
        return dataHorarioCadastro;
    }

    public void setDataHorarioCadastro(String dataHorarioCadastro) {
        this.dataHorarioCadastro = dataHorarioCadastro;
    }
}
