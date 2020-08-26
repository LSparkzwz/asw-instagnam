package asw.instagnam.ricette.publisher;

import java.util.logging.Logger;

import asw.instagnam.common.api.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.instagnam.common.api.event.DomainEvent;

@Component
public class RicettaEventPublisher implements DomainEventPublisher {

    private final Logger logger = Logger.getLogger(RicettaEventPublisher.class.toString());

    @Value("${asw.kafka.channel.out}")
    private String channel;

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    @Override
    public void publish(DomainEvent event) {
        logger.info("RICETTA PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}










