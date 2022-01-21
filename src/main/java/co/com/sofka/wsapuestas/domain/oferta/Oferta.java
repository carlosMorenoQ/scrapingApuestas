package co.com.sofka.wsapuestas.domain.oferta;

import co.com.sofka.wsapuestas.domain.generic.AggregateRoot;
import co.com.sofka.wsapuestas.domain.generic.DomainEvent;
import co.com.sofka.wsapuestas.domain.oferta.event.EncuentroAsignado;
import co.com.sofka.wsapuestas.domain.oferta.event.OfertaCreada;

import java.util.List;
import java.util.Map;

public class Oferta extends AggregateRoot {

    protected Map<String, Encuentro> encuentros;
    protected String nombreOferta;

    public Oferta(String id) {
        super(id);
        subscribe(new OfertaEventChange(this));
    }

    public Oferta(
            String ofertaId,
            String nombreOferta) {
        super(ofertaId);
        subscribe(new OfertaEventChange(this));
        appendChange(new OfertaCreada(nombreOferta)).apply();
    }

    public static Oferta from(String id, List<DomainEvent> events) {
        var oferta = new Oferta(id);
        events.forEach(oferta::applyEvent);
        return oferta;
    }

    public void agregarEncuentro(
            String encuentroId,
            String local,
            String visitante,
            List<String> apuestas) {

        appendChange(new EncuentroAsignado(
                encuentroId,
                local,
                visitante,
                apuestas
        )).apply();
    }

    public Map<String, Encuentro> encuentros() {
        return encuentros;
    }

    public String nombreOferta() {
        return nombreOferta;
    }
}
