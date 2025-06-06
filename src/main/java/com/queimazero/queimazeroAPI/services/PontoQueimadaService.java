package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.models.dto.PontoQueimadaDTO;
import com.queimazero.queimazeroAPI.repositories.PontoQueimadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoQueimadaService {

    @Autowired
    private PontoQueimadaRepository pontoQueimadaRepository;

    @Autowired
    private MunicipioService municipioService;

    public void salvarPontoQueimada(PontoQueimadaDTO pontoQueimadaDTO) {
        PontoQueimada pontoQueimada = new PontoQueimada();
        pontoQueimada.setDataQueimada(pontoQueimadaDTO.getDataQueimada());
        pontoQueimada.setIntensidadeQueimada(pontoQueimadaDTO.getIntensidadeQueimada());
        pontoQueimada.setMunicipio(municipioService.consultarMunicipioPorNome(pontoQueimadaDTO.getMunicipio()));
        pontoQueimada.setLatitudeQueimada(pontoQueimadaDTO.getLatitudeQueimada());
        pontoQueimada.setLongitudeQueimada(pontoQueimadaDTO.getLongitudeQueimada());

        pontoQueimadaRepository.save(pontoQueimada);
    }

    public void salvarPontoQueimada(List<PontoQueimadaDTO> pontoQueimadaDTO) {
        for(PontoQueimadaDTO dto : pontoQueimadaDTO) {
            salvarPontoQueimada(dto);
        }
    }

    public PontoQueimada consultarPontoQueimada(Long id) {
        Optional<PontoQueimada> pontoQueimada = this.pontoQueimadaRepository.findById(id);
        if (pontoQueimada.isEmpty()) {
            throw new RuntimeException(
                    "Ponto de queimada não encontrado! Id: " + id + ", Tipo: " + PontoQueimada.class.getName());
        }

        return pontoQueimada.get();
    }
}
