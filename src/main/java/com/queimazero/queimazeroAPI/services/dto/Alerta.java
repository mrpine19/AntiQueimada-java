package com.queimazero.queimazeroAPI.services.dto;

public class Alerta {
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Alerta genérico enviado para " + destinatario + ": " + mensagem);
    }
}
