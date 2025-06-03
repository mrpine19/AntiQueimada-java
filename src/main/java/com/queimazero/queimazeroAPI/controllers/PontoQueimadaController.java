package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.models.dto.PontoQueimadaDTO;
import com.queimazero.queimazeroAPI.services.PontoQueimadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ponto-queimadas")
public class PontoQueimadaController {

    @Autowired
    private PontoQueimadaService pontoQueimadaService;

    @PostMapping
    public ResponseEntity<PontoQueimada> criarPontoQueimada(@RequestBody PontoQueimadaDTO pontoQueimadaDTO){
        PontoQueimada pontoQueimada = pontoQueimadaService.salvarPontoQueimada(pontoQueimadaDTO);
        return new ResponseEntity<>(pontoQueimada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoQueimada> consultarPontoQueimada(@PathVariable Long id){
        PontoQueimada pontoQueimada = pontoQueimadaService.consultarPontoQueimada(id);
        return new ResponseEntity<>(pontoQueimada, HttpStatus.OK);
    }

}
