package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.Coordenadas;
import com.queimazero.queimazeroAPI.models.EnderecoAgricultor;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.repositories.AgricultorRepository;
import com.queimazero.queimazeroAPI.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgricultorService {

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    public void salvarAgricultor(AgricultorDTO agricultorDTO) {

        Agricultor agricultor = new Agricultor();
        agricultor.setNomeAgricultor(agricultorDTO.getNomeAgricultor());
        agricultor.setTelefoneAgricultor(agricultorDTO.getTelefoneAgricultor());
        agricultor.setEnderecoAgricultor(obterEnderecoAgricultor(agricultorDTO.getEnderecoAgricultor()));
        agricultor.getEnderecoAgricultor().setMunicipio(municipioRepository.findByNomeMunicipio(agricultorDTO.getMunicipio()));

        agricultorRepository.save(agricultor);
    }

    public void salvarAgricultor(List<AgricultorDTO> agricultoresDTO) {
        for (AgricultorDTO dto : agricultoresDTO) {
            salvarAgricultor(dto);
        }
    }

    public Agricultor consultarAgricultor(Long id) {
        Optional<Agricultor> agricultor = this.agricultorRepository.findById(id);

        if (agricultor.isEmpty()) {
            throw new RuntimeException(
                    "Agricultor não encontrado! Id: " + id + ", Tipo: " + Agricultor.class.getName());
        }

        return agricultor.get();
    }

    public static EnderecoAgricultor obterEnderecoAgricultor(String enderecoAgricultor) {
        String[] partes = enderecoAgricultor.split(",");
        String rua = partes[0].trim();
        String numero = partes[1].trim();

        EnderecoAgricultor endereco = new EnderecoAgricultor();
        endereco.setRuaAgricultor(rua);
        endereco.setNumeroEnderecoAgricultor(Integer.parseInt(numero));
        try {
            GeolocalizacaoService geolocalizacaoService = new GeolocalizacaoService();
            Coordenadas coordenadas = geolocalizacaoService.obterCoordenadas(enderecoAgricultor);

            if (coordenadas != null) {
                endereco.setLatitudeAgricultor(coordenadas.getLatitude());
                endereco.setLongitudeAgricultor(coordenadas.getLongitude());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return endereco;
    }
}
