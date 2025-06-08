package com.queimazero.queimazeroAPI.services;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.Alerta;
import com.queimazero.queimazeroAPI.models.Municipio;
import com.queimazero.queimazeroAPI.models.PontoQueimada;
import com.queimazero.queimazeroAPI.repositories.AgricultorRepository;
import com.queimazero.queimazeroAPI.repositories.AlertaRepository;
import com.queimazero.queimazeroAPI.repositories.PontoQueimadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private TelegramService telegramService; // Novo serviço para enviar mensagens

    // Executa a cada 10 minutos
    public void verificarQueimadasEEnviarAlertas() {
        // Para simulação, vamos criar uma queimada fictícia
        PontoQueimada queimadaSimulada = new PontoQueimada();
        Municipio municipioSimulado = new Municipio();
        municipioSimulado.setNomeMunicipio("Município de Teste");
        queimadaSimulada.setMunicipio(municipioSimulado);
        queimadaSimulada.setDataQueimada(LocalDateTime.now());

        // 2. Buscar agricultores no mesmo município (no caso, apenas você)
        List<Agricultor> agricultores = new ArrayList<>();
        Agricultor agricultorTeste = new Agricultor();
        agricultorTeste.setNomeAgricultor("Gustavo");
        agricultores.add(agricultorTeste);

        for (Agricultor agricultor : agricultores) {
            // 3. Criar mensagem personalizada
            String mensagem = String.format(
                    "🚨 ALERTA QUEIMAZERO - BOM JESUS/PI 🚨\n"
                            + "\n"
                            + "⚠️ Foco ativo detectado a 5km da sua localização\n"
                            + "📅 %s | 💨 Vento: %s\n"
                            + "\n"
                            + "🔴 AÇÕES IMEDIATAS (SERVIÇO OFICIAL):\n"
                            + "\n"
                            + "1️⃣ Isolamento da área:\n"
                            + "   - Crie aceiro de 3m ao redor da propriedade\n"
                            + "   - Molhe faixa de 10m junto às cercas\n"
                            + "\n"
                            + "2️⃣ Proteção pessoal:\n"
                            + "   - Use máscara úmida ou pano no rosto\n"
                            + "   - Vista roupas de algodão (evite sintéticos)\n"
                            + "\n"
                            + "3️⃣ Emergências:\n"
                            + "   - Bombeiros: 193 | Defesa Civil: 199\n"
                            + "\n"
                            + "🌫️ Se a fumaça chegar:\n"
                            + "• Feche portas e janelas\n"
                            + "• Umedeça cortinas e vãos\n"
                            + "• Leve animais para áreas abertas sem vegetação\n"
                            + "\n"
                            + "📡 Próxima atualização: %s\n"
                            + "Fonte: INPE/PrevFogo - Sistema de Monitoramento QueimaZero",

                    queimadaSimulada.getDataQueimada().format(DateTimeFormatter.ofPattern("dd/MM 'às' HH'h'mm")),
                    "Noroeste (15km/h)",
                    LocalDateTime.now().plusMinutes(15).format(DateTimeFormatter.ofPattern("HH'h'mm"))
            );


            // 4. Enviar mensagem via Telegram
            telegramService.enviarMensagem("5695097685", mensagem);


        }
    }
}
