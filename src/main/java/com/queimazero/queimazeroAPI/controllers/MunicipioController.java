package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @PostMapping
    public String criarMunicipio(@RequestBody MunicipioDTO municipioDTO) {
        municipioService.salvarMunicipio(municipioDTO);
        return "Município cadastrado com sucesso";
    }

    @PostMapping("/batch")
    public String criarAgricultores(@RequestBody List<MunicipioDTO> municipiosDTO) {
        municipioService.salvarMunicipio(municipiosDTO);
        return "Municípios cadastrado com sucesso";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> consultarMunicipio(@PathVariable Long id){
        Municipio municipio = municipioService.consultarMunicipioPorId(id);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }
}
