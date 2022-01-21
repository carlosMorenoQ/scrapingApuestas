package co.com.sofka.wsapuestas.domain.oferta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Encuentro {

    private final String id;
    private final String local;
    private final String visitante;
    private final List<String> apuestas;

    public Encuentro(
            String id,
            String local,
            String visitante) {
        this.id = id;
        this.apuestas = new ArrayList<>();
        this.local = local;
        this.visitante = visitante;
    }

    public void agregarApuesta(String apuesta) {
        this.apuestas.add(apuesta);
    }

    public String local() {
        return local;
    }

    public String visitante() {
        return visitante;
    }

    public List<String> apuestas() {
        return apuestas;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encuentro encuentro = (Encuentro) o;
        return Objects.equals(id, encuentro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
