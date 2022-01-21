package co.com.sofka.wsapuestas.usecases;

import co.com.sofka.wsapuestas.domain.generic.DomainEvent;
import co.com.sofka.wsapuestas.domain.oferta.Oferta;
import co.com.sofka.wsapuestas.domain.oferta.command.CrearOfertaCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CrearOfertaUseCase implements Function<CrearOfertaCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CrearOfertaCommand command) {
        var oferta = new Oferta(command.getOfertaId(), command.getNombre());
        return oferta.getUncommittedChanges();
    }


}
