package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.Alerta;
import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.repositories.AgricultorRepository;
import com.queimazero.queimazeroAPI.repositories.AlertaRepository;
import com.queimazero.queimazeroAPI.repositories.PontoQueimadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertaService {
    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private PontoQueimadaRepository pontoQueimadaRepository;

    @Autowired
    private AlertaRepository alertaRepository;


    @Scheduled(fixedRate = 60000) // Executa a cada 10 minutos
    public void verificarQueimadasEEnviarAlertas() {
        // 1. Buscar queimadas recentes (últimos 10 minutos)
        List<PontoQueimada> queimadasRecentes = pontoQueimadaRepository.findByDataQueimadaAfter(LocalDateTime.now().minusMinutes(10));

        if(!queimadasRecentes.isEmpty()) {
            for (PontoQueimada queimada : queimadasRecentes) {
                // 2. Buscar agricultores no mesmo município
                //List<Agricultor> agricultores = agricultorRepository.findByMunicipioNomeMunicipio(queimada.getMunicipio().getNomeMunicipio());
                List<Agricultor> agricultores = new ArrayList<>();
                for (Agricultor agricultor : agricultores) {
                    // 3. Verificar se já existe alerta não enviado para esta combinação
                    boolean alertaExistente = alertaRepository.existsByAgricultorAndPontoQueimadaAndAlertaEnviado(
                            agricultor, queimada, 'N');
                    if (!alertaExistente) {
                        // 4. Criar mensagem personalizada
                        String mensagem = String.format(
                                "ALERTA: Foco de queimada detectado em seu município. Evite usar fogo hoje.");

                        // 5. Criar e salvar alerta
                        Alerta alerta = new Alerta(mensagem, queimada, agricultor);
                        alertaRepository.save(alerta);

                        // 6. Enviar via chatbot
                        //boolean enviado = chatbotService.enviarAlerta(agricultor.getChatId(), mensagem);

                        // 7. Se enviado com sucesso, marcar como enviado
                        //if (enviado) {
                        //alerta.marcarComoEnviado();
                        //alertaChatbotRepository.save(alerta);
                        //}
                    }
                }
            }
        }
    }

}
