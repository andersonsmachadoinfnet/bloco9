package br.anderson.infnet.apppetfriendspedido.model.domain.infra;

import br.anderson.infnet.apppetfriendspedido.model.service.AlmoxarifadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class EventoClienteComprouService {
    @Autowired
    private AlmoxarifadoService almoxarifadoService;
    private static final Logger LOG = LoggerFactory.getLogger(EventoClienteComprouService.class);

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(EventoClienteComprou.class, new EventoClienteComprouSerializer());
        simpleModule.addDeserializer(EventoClienteComprou.class, new EventoClienteComprouDeserializer());
        return new JacksonPubSubMessageConverter(objectMapper);
    }

    @Bean
    public MessageChannel inputMessageChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapter(
            @Qualifier("inputMessageChannel") MessageChannel messageChannel, PubSubTemplate pubSubTemplate) {

        pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter());
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "appPetsFriendsTopic-sub");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(EventoClienteComprou.class);
        return adapter;
    }

    @ServiceActivator(inputChannel = "inputMessageChannel")
    public void messageReceiver(EventoClienteComprou payload,
                                @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) ConvertedBasicAcknowledgeablePubsubMessage<EventoClienteComprou> message) {

        almoxarifadoService.SeparaPedido(payload);
        message.ack();
    }
}
