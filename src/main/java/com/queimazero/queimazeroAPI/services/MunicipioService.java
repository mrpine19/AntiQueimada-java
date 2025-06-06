package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private GeolocalizacaoService geolocalizacaoService;

    public void salvarMunicipio(MunicipioDTO municipioDTO) {
        // Verifica se o município já existe
        if (municipioRepository.existsByNomeMunicipio(municipioDTO.getNomeMunicipio()))
            throw new RuntimeException("Município já cadastrado");

        if (municipioDTO.getUfMunicipio() == null){
            try {
                String UF = geolocalizacaoService.buscarUFporMunicipio(municipioDTO.getNomeMunicipio());
                municipioDTO.setUfMunicipio(UF);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        Municipio municipio = new Municipio();
        municipio.setNomeMunicipio(municipioDTO.getNomeMunicipio());
        municipio.setUfMunicipio(municipioDTO.getUfMunicipio());

        municipioRepository.save(municipio);
    }

    public void salvarMunicipio(List<MunicipioDTO> municipioDTO) {
        for (MunicipioDTO dto : municipioDTO) {
            salvarMunicipio(dto);
        }
    }

    public Municipio consultarMunicipioPorId(Long id) {
        Optional<Municipio> municipio = this.municipioRepository.findById(id);

        if (municipio.isEmpty()) {
            throw new RuntimeException(
                    "Município não encontrado! Id: " + id + ", Tipo: " + Municipio.class.getName());
        }

        return municipio.get();
    }

    public Municipio consultarMunicipioPorNome(String nome) {
        return this.municipioRepository.findByNomeMunicipio(nome);
    }
}
