package co.com.sofka.wsapuestas.domain.oferta.command;

import co.com.sofka.wsapuestas.domain.generic.Command;

public class CrearOfertaCommand extends Command {

    private String ofertaId;
    private String nombre;

    public CrearOfertaCommand() {
    }

    public String getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(String ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
