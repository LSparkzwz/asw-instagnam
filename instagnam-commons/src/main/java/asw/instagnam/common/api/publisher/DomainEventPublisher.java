package asw.instagnam.common.api.publisher;
import asw.instagnam.common.api.event.DomainEvent;

public interface DomainEventPublisher{
    void publish(DomainEvent event);
}
