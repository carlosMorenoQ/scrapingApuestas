package co.com.sofka.wsapuestas.domain.oferta;

import co.com.sofka.wsapuestas.domain.generic.EventChange;
import co.com.sofka.wsapuestas.domain.oferta.event.EncuentroAsignado;
import co.com.sofka.wsapuestas.domain.oferta.event.OfertaCreada;

import java.util.HashMap;

public class OfertaEventChange implements EventChange {

    public OfertaEventChange(Oferta oferta){

        listener((OfertaCreada event)->{
            oferta.nombreOferta = event.getNombre();
            oferta.encuentros = new HashMap<>();
        });

        listener((EncuentroAsignado event)->{
            var encuentro = new Encuentro(
                    event.getId(),
                    event.getLocal(),
                    event.getVisitante());
            event.getApuestas().forEach(encuentro::agregarApuesta);
            oferta.encuentros.put("encuentros", encuentro);
        });

    }





}
