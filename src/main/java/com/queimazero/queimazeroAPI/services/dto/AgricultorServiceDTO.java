package com.queimazero.queimazeroAPI.services.dto;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.EnderecoAgricultor;
import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.dto.AgricultorDTO;
import com.queimazero.queimazeroAPI.models.dto.MunicipioDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgricultorServiceDTO {
    private List<Agricultor> agricultores = new ArrayList<>();
    private Long nextId = 1L;
    private MunicipioServiceDTO municipioServiceDTO;

    public AgricultorServiceDTO(MunicipioServiceDTO municipioService) {
        this.municipioServiceDTO = municipioService;
    }

    public void salvarAgricultor(AgricultorDTO agricultorDTO) {
        Municipio municipio = municipioServiceDTO.consultarMunicipioPorNome(agricultorDTO.getMunicipio());

        if (municipio == null) {
            MunicipioDTO municipioDTO = new MunicipioDTO(agricultorDTO.getMunicipio(), null);
            municipioServiceDTO.salvarMunicipio(municipioDTO);
            municipio = municipioServiceDTO.consultarMunicipioPorNome(agricultorDTO.getMunicipio());
        }

        Agricultor agricultor = new Agricultor();
        agricultor.setIdAgricultor(nextId++);
        agricultor.setNomeAgricultor(agricultorDTO.getNomeAgricultor());
        agricultor.setTelefoneAgricultor(agricultorDTO.getTelefoneAgricultor());

        EnderecoAgricultor endereco = new EnderecoAgricultor();
        endereco.setIdEnderecoAgricultor(nextId++);
        endereco.setRuaAgricultor(agricultorDTO.getEnderecoAgricultor());
        endereco.setMunicipio(municipio);

        agricultor.setEnderecoAgricultor(endereco);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        agricultor.setDataHorarioCadastro(LocalDateTime.now().format(formatter));

        agricultores.add(agricultor);
        System.out.println("Agricultor cadastrado com sucesso: " + agricultor.getNomeAgricultor());
    }

    public void cadastrarAgricultor(Scanner scanner) {
        AgricultorDTO dto = new AgricultorDTO();

        System.out.print("Nome do agricultor: ");
        dto.setNomeAgricultor(scanner.nextLine());

        System.out.print("Telefone: ");
        dto.setTelefoneAgricultor(scanner.nextLine());

        System.out.print("Município: ");
        dto.setMunicipio(scanner.nextLine());

        System.out.print("Endereço: ");
        dto.setEnderecoAgricultor(scanner.nextLine());

        salvarAgricultor(dto);
    }

    public void listarAgricultores() {
        System.out.println("\nAgricultores cadastrados:");
        System.out.println("----------------------------------------");

        List<Agricultor> listaAgricultores = new ArrayList<>(agricultores);
        if (listaAgricultores.isEmpty()) {
            System.out.println("Nenhum agricultor cadastrado.");
        } else {
            for (Agricultor a : listaAgricultores) {
                System.out.println("ID: " + a.getIdAgricultor());
                System.out.println("Nome: " + a.getNomeAgricultor());
                System.out.println("Telefone: " + a.getTelefoneAgricultor());
                System.out.println("Endereço: " + a.getEnderecoAgricultor().getRuaAgricultor());
                System.out.println("Município: " + a.getEnderecoAgricultor().getMunicipio().getNomeMunicipio());
                System.out.println("Data Cadastro: " + a.getDataHorarioCadastro());
                System.out.println("----------------------------------------");
            }
        }
    }

    public List<Agricultor> retornaListarAgricultores() {
        System.out.println("\nAgricultores cadastrados:");
        System.out.println("----------------------------------------");

        List<Agricultor> listaAgricultores = new ArrayList<>(agricultores);
        if (listaAgricultores.isEmpty()) {
            System.out.println("Nenhum agricultor cadastrado.");
        } else {
            for (Agricultor a : listaAgricultores) {
                System.out.println("ID: " + a.getIdAgricultor());
                System.out.println("Nome: " + a.getNomeAgricultor());
                System.out.println("Telefone: " + a.getTelefoneAgricultor());
                System.out.println("Endereço: " + a.getEnderecoAgricultor().getRuaAgricultor());
                System.out.println("Município: " + a.getEnderecoAgricultor().getMunicipio().getNomeMunicipio());
                System.out.println("Data Cadastro: " + a.getDataHorarioCadastro());
                System.out.println("----------------------------------------");
            }
        }

        return listaAgricultores;
    }
}
