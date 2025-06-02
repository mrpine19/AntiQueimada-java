package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public Municipio salvarMunicipio(MunicipioDTO municipioDTO) {
        // Verifica se o município já existe
        if (municipioRepository.existsByNomeMunicipio(municipioDTO.getNomeMunicipio())) {
            throw new RuntimeException("Município já cadastrado");
        }

        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio(municipioDTO.getNomeMunicipio());
        municipio.setUfMunicipio(municipioDTO.getUfMunicipio());

        return municipioRepository.save(municipio);
    }

    public Municipio consultarMunicipio(Long id) {
        Optional<Municipio> municipio = this.municipioRepository.findById(id);

        if (municipio.isEmpty()) {
            throw new RuntimeException(
                    "Município não encontrado! Id: " + id + ", Tipo: " + Municipio.class.getName());
        }

        return municipio.get();
    }
}
