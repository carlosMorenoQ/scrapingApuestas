package co.com.sofka.wsapuestas.domain.oferta.command;

import co.com.sofka.wsapuestas.domain.generic.Command;

import java.util.List;

public class AsignarEncuentroCommand extends Command {

    private String ofertaId;
    private String encuentroId;
    private String local;
    private String visitante;
    private List<String> apuestas;

    public AsignarEncuentroCommand() {
    }

    public String getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(String ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getEncuentroId() {
        return encuentroId;
    }

    public void setEncuentroId(String encuentroId) {
        this.encuentroId = encuentroId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public List<String> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<String> apuestas) {
        this.apuestas = apuestas;
    }
}
