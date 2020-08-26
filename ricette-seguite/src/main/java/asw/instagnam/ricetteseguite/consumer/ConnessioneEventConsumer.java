package asw.instagnam.ricetteseguite.consumer;

import java.util.logging.Logger;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioneEventConsumer {

    private final Logger logger = Logger.getLogger(ConnessioneEventConsumer.class.toString());

    @Autowired
    private RicetteSeguiteService ricetteSeguiteService;

    @KafkaListener(topics = "${asw.kafka.channel.in.connessioni}")
    public void listen(ConsumerRecord<String, DomainEvent> record) {
        DomainEvent event = record.value();
        if (event.getClass().equals(ConnessioneCreatedEvent.class)) {
            logger.info("Connessione received:");
            ricetteSeguiteService.createConnessione((ConnessioneCreatedEvent) event);
        }
    }
}