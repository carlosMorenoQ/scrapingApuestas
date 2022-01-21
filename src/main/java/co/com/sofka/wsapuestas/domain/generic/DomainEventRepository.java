package co.com.sofka.wsapuestas.domain.generic;


import java.util.List;


public interface DomainEventRepository {

    List<DomainEvent> getEventsBy(String aggregateRootId);

    List<DomainEvent> getEventsBy(String aggregate, String aggregateRootId);
}