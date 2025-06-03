package com.queimazero.queimazeroAPI.controllers;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @PostMapping
    public ResponseEntity<Municipio> criarMunicipio(@RequestBody MunicipioDTO municipioDTO) {
        Municipio novoMunicipio = municipioService.salvarMunicipio(municipioDTO);
        return new ResponseEntity<>(novoMunicipio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> consultarMunicipio(@PathVariable Long id){
        Municipio municipio = municipioService.consultarMunicipioPorId(id);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }
}
