package br.anderson.infnet.appPbApiReceitaMedica.model.rabbitmq;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.ReceitaMedica;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceitaProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(ReceitaMedica rm) throws JsonProcessingException {
        amqpTemplate.convertAndSend("receita-exc", "receita-rk", objectMapper.writeValueAsString(rm));
    }
}
