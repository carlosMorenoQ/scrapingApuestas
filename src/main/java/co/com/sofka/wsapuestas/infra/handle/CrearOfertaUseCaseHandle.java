package co.com.sofka.wsapuestas.infra.handle;

import co.com.sofka.wsapuestas.domain.oferta.command.CrearOfertaCommand;
import co.com.sofka.wsapuestas.infra.generic.UseCaseHandle;
import co.com.sofka.wsapuestas.usecases.CrearOfertaUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CrearOfertaUseCaseHandle extends UseCaseHandle {

    private final CrearOfertaUseCase crearOfertaUseCase;

    public CrearOfertaUseCaseHandle(CrearOfertaUseCase crearOfertaUseCase){
        this.crearOfertaUseCase = crearOfertaUseCase;
    }

    @ConsumeEvent(value="sofkau.oferta.crearoferta")
    void cosumeBlocking(CrearOfertaCommand command){
        var events = crearOfertaUseCase.apply(command);
        saveOferta(command.getOfertaId(), events);
    }

}
