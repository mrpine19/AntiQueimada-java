package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.repositories.AgricultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgricultorService {

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private MunicipioService municipioService;

    public Agricultor salvarAgricultor(AgricultorDTO agricultorDTO) {

        Agricultor agricultor = new Agricultor();
        agricultor.setNomeAgricultor(agricultorDTO.getNomeAgricultor());
        agricultor.setTelefoneAgricultor(agricultorDTO.getTelefoneAgricultor());
        agricultor.setMunicipio(municipioService.consultarMunicipioPorId(agricultorDTO.getMunicipio()));

        return agricultorRepository.save(agricultor);
    }

    public Agricultor consultarAgricultor(Long id) {
        Optional<Agricultor> agricultor = this.agricultorRepository.findById(id);

        if (agricultor.isEmpty()) {
            throw new RuntimeException(
                    "Agricultor não encontrado! Id: " + id + ", Tipo: " + Agricultor.class.getName());
        }

        return agricultor.get();
    }
}
