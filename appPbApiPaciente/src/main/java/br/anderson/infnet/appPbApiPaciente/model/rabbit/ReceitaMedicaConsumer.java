package br.anderson.infnet.appPbApiPaciente.model.rabbit;

import br.anderson.infnet.appPbApiPaciente.model.domain.evento.EventoReceitaMedica;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ReceitaMedicaConsumer {
    private final ObjectMapper objectMapper;
    @RabbitListener(queues = {"receita-fila"})
    public void receive(@Payload String json) {
        EventoReceitaMedica receita = null;
        try {
            receita = objectMapper.readValue(json, EventoReceitaMedica.class);
            log.info("Receita recebida: " + receita);
            log.info("            json: " + json);
        } catch (JsonProcessingException e) {
            log.info("MsgBad: " + json);
            throw new RuntimeException(e);
        }
    }
}

