package com.queimazero.queimazeroAPI.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramService {

    private static final Logger logger = LoggerFactory.getLogger(TelegramService.class);

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.api.url}")
    private String telegramApiUrl;

    public void enviarMensagem(String chatId, String mensagem) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String requestBody = String.format("{\"chat_id\": \"%s\", \"text\": \"%s\"}", chatId, mensagem);

            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            String url = telegramApiUrl + botToken + "/sendMessage";

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Mensagem enviada com sucesso para o chat ID: {}", chatId);
            } else {
                logger.error("Falha ao enviar mensagem. Resposta: {}", response.getBody());
            }
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem via Telegram", e);
        }
    }
}
