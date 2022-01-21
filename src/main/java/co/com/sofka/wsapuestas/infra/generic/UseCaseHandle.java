package co.com.sofka.wsapuestas.infra.generic;

import co.com.sofka.wsapuestas.domain.generic.DomainEvent;
import co.com.sofka.wsapuestas.domain.generic.EventStoreRepository;
import co.com.sofka.wsapuestas.domain.generic.StoredEvent;
import co.com.sofka.wsapuestas.infra.message.BusService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

//@ApplicationScoped
public abstract class UseCaseHandle {
    @Inject
    private  EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void saveOferta(String ofertaId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("oferta", ofertaId, storedEvent));

        events.forEach(busService::send);
    }
}
