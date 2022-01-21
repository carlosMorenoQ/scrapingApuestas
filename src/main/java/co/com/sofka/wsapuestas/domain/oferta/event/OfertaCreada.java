package co.com.sofka.wsapuestas.domain.oferta.event;

import co.com.sofka.wsapuestas.domain.generic.DomainEvent;

public class OfertaCreada extends DomainEvent {

    private final String nombre;

    public OfertaCreada(String nombre) {
        super("sofkau.oferta.ofertacreada");
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
