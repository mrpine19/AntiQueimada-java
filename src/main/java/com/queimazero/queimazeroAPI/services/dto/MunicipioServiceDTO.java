package com.queimazero.queimazeroAPI.services.dto;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.services.GeolocalizacaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MunicipioServiceDTO {
    private List<Municipio> municipios = new ArrayList<>();
    private Long nextId = 1L;
    private GeolocalizacaoService geolocalizacaoService = new GeolocalizacaoService();

    public Municipio consultarMunicipioPorNome(String nome) {
        return municipios.stream()
                .filter(m -> m.getNomeMunicipio().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public boolean existeMunicipioPorNome(String nome) {
        return municipios.stream()
                .anyMatch(m -> m.getNomeMunicipio().equalsIgnoreCase(nome));
    }

    public void salvarMunicipio(MunicipioDTO municipioDTO) {
        if (existeMunicipioPorNome(municipioDTO.getNomeMunicipio())) {
            System.out.println("Erro: Município já cadastrado!");
            return;
        }

        if (municipioDTO.getUfMunicipio() == null || municipioDTO.getUfMunicipio().isEmpty()) {
            try {
                String uf = geolocalizacaoService.buscarUFporMunicipio(municipioDTO.getNomeMunicipio());
                municipioDTO.setUfMunicipio(uf);
                System.out.println("UF determinada automaticamente: " + uf);
            } catch (Exception e) {
                System.out.println("Erro ao determinar UF: " + e.getMessage());
                municipioDTO.setUfMunicipio("UF");
            }
        }

        Municipio municipio = new Municipio();
        municipio.setIdMunicipio(nextId++);
        municipio.setNomeMunicipio(municipioDTO.getNomeMunicipio());
        municipio.setUfMunicipio(municipioDTO.getUfMunicipio());

        municipios.add(municipio);
        System.out.println("Município cadastrado com sucesso: " +
                municipio.getNomeMunicipio() + "/" + municipio.getUfMunicipio());
    }

    public void cadastrarMunicipio(Scanner scanner) {
        MunicipioDTO dto = new MunicipioDTO(null, null);

        System.out.println("\nCadastro de Município");
        System.out.println("---------------------");

        System.out.print("Nome do município: ");
        dto.setNomeMunicipio(scanner.nextLine());

        System.out.print("UF (deixe em branco para tentar determinar automaticamente): ");
        String uf = scanner.nextLine();
        if (!uf.isEmpty()) {
            dto.setUfMunicipio(uf);
        }

        salvarMunicipio(dto);
    }

    public void listarMunicipios() {
        System.out.println("\nMunicípios cadastrados:");
        System.out.println("----------------------------------------");

        List<Municipio> listaMunicipios = new ArrayList<>(municipios);
        if (listaMunicipios.isEmpty()) {
            System.out.println("Nenhum município cadastrado.");
        } else {
            for (Municipio m : listaMunicipios) {
                System.out.println("ID: " + m.getIdMunicipio());
                System.out.println("Nome: " + m.getNomeMunicipio());
                System.out.println("UF: " + m.getUfMunicipio());
                System.out.println("----------------------------------------");
            }
        }
    }


}
