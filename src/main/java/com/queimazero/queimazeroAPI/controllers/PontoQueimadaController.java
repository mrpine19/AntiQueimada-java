package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.models.dto.PontoQueimadaDTO;
import com.queimazero.queimazeroAPI.services.PontoQueimadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ponto-queimadas")
public class PontoQueimadaController {

    @Autowired
    private PontoQueimadaService pontoQueimadaService;

    @PostMapping
    public String criarPontoQueimada(@RequestBody PontoQueimadaDTO pontoQueimadaDTO){
        pontoQueimadaService.salvarPontoQueimada(pontoQueimadaDTO);
        return "Ponto de queimada cadastrada com sucesso!";
    }

    @PostMapping("/batch")
    public String criarPontosQueimada(@RequestBody List<PontoQueimadaDTO> PontoQueimadaDTO) {
        pontoQueimadaService.salvarPontoQueimada(PontoQueimadaDTO);
        return "Pontos de queimada cadastradas com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoQueimada> consultarPontoQueimada(@PathVariable Long id){
        PontoQueimada pontoQueimada = pontoQueimadaService.consultarPontoQueimada(id);
        return new ResponseEntity<>(pontoQueimada, HttpStatus.OK);
    }

}
