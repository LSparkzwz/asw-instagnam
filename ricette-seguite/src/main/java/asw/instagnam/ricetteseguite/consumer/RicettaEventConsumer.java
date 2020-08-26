package asw.instagnam.ricetteseguite.consumer;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.common.api.event.RicettaCreatedEvent;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RicettaEventConsumer{

    private final Logger logger = Logger.getLogger(ConnessioneEventConsumer.class.toString());

    @Autowired
    private RicetteSeguiteService service;

    @KafkaListener(topics = "${asw.kafka.channel.in.ricette}")
    public void listen(ConsumerRecord<String, DomainEvent> record) {
        DomainEvent event = record.value();
        if (event.getClass().equals(RicettaCreatedEvent.class)) {
            logger.info("Ricetta received:");
            service.createRicetta((RicettaCreatedEvent)event);
        }
    }
}
