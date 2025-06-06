package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.services.AgricultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agricultores")
public class AgricultorController {

    @Autowired
    private AgricultorService agricultorService;

    @PostMapping
    public String criarAgricultor(@RequestBody AgricultorDTO agricultorDTO) {
        agricultorService.salvarAgricultor(agricultorDTO);
        return "Agricultor cadastrado com sucesso!";
    }

    @PostMapping("/batch")
    public String criarAgricultores(@RequestBody List<AgricultorDTO> agricultoresDTO) {
        agricultorService.salvarAgricultor(agricultoresDTO);
        return "Agricultores cadastrados com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agricultor> consultarAgricultor(@PathVariable Long id){
        Agricultor agricultor = agricultorService.consultarAgricultor(id);
        return new ResponseEntity<>(agricultor, HttpStatus.OK);
    }
}
