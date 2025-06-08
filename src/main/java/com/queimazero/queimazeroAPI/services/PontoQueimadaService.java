package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
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

    @Autowired
    private AlertaService alertaService;

    public void salvarPontoQueimada(PontoQueimadaDTO pontoQueimadaDTO) {
        Municipio municipio = municipioService.consultarMunicipioPorNome(pontoQueimadaDTO.getMunicipio());

        if (municipio == null) {
            MunicipioDTO municipioDTO = new MunicipioDTO(pontoQueimadaDTO.getMunicipio(), null);
            municipioService.salvarMunicipio(municipioDTO);
            municipio = municipioService.consultarMunicipioPorNome(pontoQueimadaDTO.getMunicipio()); // Consulta novamente
        }

        PontoQueimada pontoQueimada = new PontoQueimada();
        pontoQueimada.setDataQueimada(pontoQueimadaDTO.getDataQueimada());
        pontoQueimada.setIntensidadeQueimada(pontoQueimadaDTO.getIntensidadeQueimada());
        pontoQueimada.setMunicipio(municipio);
        pontoQueimada.setLatitudeQueimada(pontoQueimadaDTO.getLatitudeQueimada());
        pontoQueimada.setLongitudeQueimada(pontoQueimadaDTO.getLongitudeQueimada());

        pontoQueimadaRepository.save(pontoQueimada);
        alertaService.verificarQueimadasEEnviarAlertas();
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
