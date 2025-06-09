package com.queimazero.queimazeroAPI.services.dto;

import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;
import com.queimazero.queimazeroAPI.models.dto.PontoQueimadaDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PontoQueimadaServiceDTO {
    private List<PontoQueimada> pontosQueimada = new ArrayList<>();
    private Long nextId = 1L;
    private MunicipioServiceDTO municipioServiceDTO;

    public PontoQueimadaServiceDTO(MunicipioServiceDTO municipioServiceDTO) {
        this.municipioServiceDTO = municipioServiceDTO;
    }

    public void salvarPontoQueimada(PontoQueimadaDTO pontoQueimadaDTO) {
        Municipio municipio = municipioServiceDTO.consultarMunicipioPorNome(pontoQueimadaDTO.getMunicipio());

        if (municipio == null) {
            MunicipioDTO municipioDTO = new MunicipioDTO(pontoQueimadaDTO.getMunicipio(), null);
            municipioServiceDTO.salvarMunicipio(municipioDTO);
            municipio = municipioServiceDTO.consultarMunicipioPorNome(pontoQueimadaDTO.getMunicipio());
        }

        PontoQueimada pontoQueimada = new PontoQueimada();
        pontoQueimada.setId(nextId++);
        pontoQueimada.setDataQueimada(pontoQueimadaDTO.getDataQueimada());
        pontoQueimada.setIntensidadeQueimada(pontoQueimadaDTO.getIntensidadeQueimada());
        pontoQueimada.setMunicipio(municipio);
        pontoQueimada.setLatitudeQueimada(pontoQueimadaDTO.getLatitudeQueimada());
        pontoQueimada.setLongitudeQueimada(pontoQueimadaDTO.getLongitudeQueimada());

        pontosQueimada.add(pontoQueimada);

        System.out.println("Ponto de queimada cadastrado com sucesso em " +
                municipio.getNomeMunicipio() + "/" + municipio.getUfMunicipio());
    }

    public void cadastrarPontoQueimada(Scanner scanner) {
        PontoQueimadaDTO dto = new PontoQueimadaDTO();

        System.out.println("\nCadastro de Ponto de Queimada");
        System.out.println("-----------------------------");

        System.out.print("Município: ");
        dto.setMunicipio(scanner.nextLine());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        boolean dataValida = false;

        while (!dataValida) {
            System.out.print("Data e Hora (dd/MM/aaaa HH:mm): ");
            String dataInput = scanner.nextLine();

            try {
                LocalDateTime dataQueimada = LocalDateTime.parse(dataInput, formatter);
                dto.setDataQueimada(dataQueimada);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use o formato dd/MM/aaaa HH:mm (ex: 15/06/2025 14:30)");
                System.out.println("Deseja usar a data e hora atual? (S/N)");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("S")) {
                    dto.setDataQueimada(LocalDateTime.now());
                    dataValida = true;
                }
            }
        }

        System.out.print("Intensidade (leve/moderada/grave): ");
        dto.setIntensidadeQueimada(scanner.nextLine());

        System.out.print("Latitude (ex: -23.5505): ");
        dto.setLatitudeQueimada(new BigDecimal(scanner.nextLine()));

        System.out.print("Longitude (ex: -46.6333): ");
        dto.setLongitudeQueimada(new BigDecimal(scanner.nextLine()));

        salvarPontoQueimada(dto);
    }

    public void listarPontosQueimada() {
        System.out.println("\nPontos de Queimada cadastrados:");
        System.out.println("----------------------------------------");

        List<PontoQueimada> listaPontosQueimada = new ArrayList<>(pontosQueimada);
        if (listaPontosQueimada.isEmpty()) {
            System.out.println("Nenhum ponto de queimada cadastrado.");
        } else {
            for (PontoQueimada p : listaPontosQueimada) {
                System.out.println("ID: " + p.getId());
                System.out.println("Data: " + p.getDataQueimada());
                System.out.println("Intensidade: " + p.getIntensidadeQueimada());
                System.out.println("Município: " + p.getMunicipio().getNomeMunicipio() + "/" + p.getMunicipio().getUfMunicipio());
                System.out.println("Latitude: " + p.getLatitudeQueimada());
                System.out.println("Longitude: " + p.getLongitudeQueimada());
                System.out.println("----------------------------------------");
            }
        }
    }
}