package co.com.sofka.wsapuestas.domain.oferta.event;

import co.com.sofka.wsapuestas.domain.generic.DomainEvent;

import java.util.List;

public class EncuentroAsignado extends DomainEvent {

    private final String encuentroId;
    private final String local;
    private final String visitante;
    private final List<String> apuestas;

    public EncuentroAsignado(String encuentroId,
                             String local,
                             String visitante,
                             List<String> apuestas) {
        super("sofkau.oferta.encuentroasignado");
        this.encuentroId = encuentroId;
        this.local = local;
        this.visitante = visitante;
        this.apuestas = apuestas;
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public List<String> getApuestas() {
        return apuestas;
    }

}
