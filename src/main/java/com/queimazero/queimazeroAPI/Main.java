package com.queimazero.queimazeroAPI;




import com.queimazero.queimazeroAPI.services.dto.AgricultorServiceDTO;
import com.queimazero.queimazeroAPI.services.dto.AlertaQueimada;
import com.queimazero.queimazeroAPI.services.dto.MunicipioServiceDTO;
import com.queimazero.queimazeroAPI.services.dto.PontoQueimadaServiceDTO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MunicipioServiceDTO municipioService = new MunicipioServiceDTO();
        AgricultorServiceDTO agricultorService = new AgricultorServiceDTO(municipioService);
        PontoQueimadaServiceDTO pontoQueimadaService = new PontoQueimadaServiceDTO(municipioService);
        AlertaQueimada alertaQueimada = new AlertaQueimada();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Cadastro para Alerta de Queimadas - QueimaZero");
        System.out.println("-------------------------------------------");

        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Cadastrar município");
            System.out.println("2 - Cadastrar agricultor");
            System.out.println("3 - Cadastrar ponto de queimada");
            System.out.println("4 - Listar municípios cadastrados");
            System.out.println("5 - Listar agricultores cadastrados");
            System.out.println("6 - Listar pontos de queimada");
            System.out.println("7 - Enviar alerta de queimada");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    municipioService.cadastrarMunicipio(scanner);
                    break;
                case 2:
                    agricultorService.cadastrarAgricultor(scanner);
                    break;
                case 3:
                    pontoQueimadaService.cadastrarPontoQueimada(scanner);
                    break;
                case 4:
                    municipioService.listarMunicipios();
                    break;
                case 5:
                    agricultorService.listarAgricultores();
                    break;
                case 6:
                    pontoQueimadaService.listarPontosQueimada();
                    break;
                case 7:
                    alertaQueimada.enviarAlertaQueimada(scanner, agricultorService);
                case 8:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
