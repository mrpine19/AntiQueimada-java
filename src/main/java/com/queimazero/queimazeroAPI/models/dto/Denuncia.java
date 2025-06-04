package com.queimazero.queimazeroAPI.models.dto;

import com.queimazero.queimazeroAPI.models.PontoQueimada;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DENUNCIA")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Long idDenuncia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_queimada", nullable = false)
    private PontoQueimada pontoQueimada;

    @Column(name = "data_denuncia", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataQueimada;

    public Denuncia() {
    }

    public Denuncia(Long idDenuncia, PontoQueimada pontoQueimada, LocalDateTime dataQueimada) {
        this.idDenuncia = idDenuncia;
        this.pontoQueimada = pontoQueimada;
        this.dataQueimada = dataQueimada;
    }

    public Long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public PontoQueimada getPontoQueimada() {
        return pontoQueimada;
    }

    public void setPontoQueimada(PontoQueimada pontoQueimada) {
        this.pontoQueimada = pontoQueimada;
    }

    public LocalDateTime getDataQueimada() {
        return dataQueimada;
    }

    public void setDataQueimada(LocalDateTime dataQueimada) {
        this.dataQueimada = dataQueimada;
    }
}
