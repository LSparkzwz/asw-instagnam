package asw.instagnam.connessioni.publisher;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.common.api.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioneEventPublisher implements DomainEventPublisher {
    private final Logger logger = Logger.getLogger(ConnessioneEventPublisher.class.toString());

    @Value("${asw.kafka.channel.out}")
    private String channel;

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    @Override
    public void publish(DomainEvent event) {
        logger.info("CONNESSIONI PUBLISHING EVENT: " + event.toString() +" ON CHANNEL: " + channel);
        template.send(channel, event);
    }

}
