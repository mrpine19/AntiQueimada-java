package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.services.AgricultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agricultores")
public class AgricultorController {

    @Autowired
    private AgricultorService agricultorService;

    @PostMapping
    public ResponseEntity<Agricultor> criarAgricultor(@RequestBody AgricultorDTO agricultorDTO) {
        Agricultor novoAgricultor = agricultorService.salvarAgricultor(agricultorDTO);
        return new ResponseEntity<>(novoAgricultor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agricultor> consultarAgricultor(@PathVariable Long id){
        Agricultor agricultor = agricultorService.consultarAgricultor(id);
        return new ResponseEntity<>(agricultor, HttpStatus.OK);
    }
}
