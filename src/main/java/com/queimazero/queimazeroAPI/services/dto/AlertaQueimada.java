package com.queimazero.queimazeroAPI.services.dto;

import com.queimazero.queimazeroAPI.models.Agricultor;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AlertaQueimada extends Alerta {

    public void enviarAlertaQueimada(Scanner scanner, AgricultorServiceDTO agricultorService) {
        List<Agricultor> agricultores = agricultorService.retornaListarAgricultores();

        if (agricultores.isEmpty()) {
            System.out.println("Não há agricultores cadastrados para enviar alertas.");
            return;
        }

        System.out.println("\nAgricultores cadastrados:");
        for (Agricultor a : agricultores) {
            System.out.println("ID: " + a.getIdAgricultor() + " - " + a.getNomeAgricultor() +
                    " (" + a.getEnderecoAgricultor().getMunicipio().getNomeMunicipio() + ")");
        }

        System.out.print("\nDigite o ID do agricultor que receberá o alerta: ");
        long idAgricultor = scanner.nextLong();
        scanner.nextLine();

        Optional<Agricultor> agricultorSelecionado = agricultores.stream()
                .filter(a -> a.getIdAgricultor() == idAgricultor)
                .findFirst();

        if (agricultorSelecionado.isPresent()) {
            System.out.print("Digite a mensagem de alerta: ");
            String mensagem = scanner.nextLine();

            System.out.print("Distância aproximada em km (opcional, pressione Enter para pular): ");
            String distanciaInput = scanner.nextLine();

            if (!distanciaInput.isEmpty()) {
                try {
                    double distancia = Double.parseDouble(distanciaInput);
                    enviarComDistancia(agricultorSelecionado.get(), mensagem, distancia);
                } catch (NumberFormatException e) {
                    System.out.println("Distância inválida. Enviando alerta sem informação de distância.");
                    enviarParaAgricultor(agricultorSelecionado.get(), mensagem);
                }
            } else {
                enviarParaAgricultor(agricultorSelecionado.get(), mensagem);
            }
        } else {
            System.out.println("Agricultor com ID " + idAgricultor + " não encontrado.");
        }
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        String mensagemFormatada = "🚨 ALERTA DE QUEIMADA PRÓXIMA 🚨\n" + mensagem +
                "\nTome as devidas precauções!";
        System.out.println("\n----------------------------------------");
        System.out.println("\nAlerta especializado enviado para " + destinatario +
                ":\n" + mensagemFormatada);
    }

    // Método para enviar alerta diretamente a um agricultor
    public void enviarParaAgricultor(Agricultor agricultor, String mensagem) {
        String detalhesLocal = "\nLocal: " + agricultor.getEnderecoAgricultor().getRuaAgricultor() +
                ", " + agricultor.getEnderecoAgricultor().getMunicipio().getNomeMunicipio();
        enviar(agricultor.getNomeAgricultor(), mensagem + detalhesLocal);
    }

    // Método para enviar alerta com distância
    public void enviarComDistancia(Agricultor agricultor, String mensagem, double distanciaKm) {
        String mensagemCompleta = mensagem + "\nDistância aproximada: " +
                distanciaKm + " km do seu local em " +
                agricultor.getEnderecoAgricultor().getMunicipio().getNomeMunicipio();
        enviarParaAgricultor(agricultor, mensagemCompleta);
    }
}
