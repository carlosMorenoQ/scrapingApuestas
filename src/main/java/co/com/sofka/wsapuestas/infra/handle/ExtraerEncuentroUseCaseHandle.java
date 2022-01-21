package co.com.sofka.wsapuestas.infra.handle;

import co.com.sofka.wsapuestas.domain.oferta.command.AsignarEncuentroCommand;
import co.com.sofka.wsapuestas.infra.generic.UseCaseHandle;
import co.com.sofka.wsapuestas.usecases.ExtraerEncuentroUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExtraerEncuentroUseCaseHandle extends UseCaseHandle {

    private final ExtraerEncuentroUseCase extraerEncuentroUseCase;

    public ExtraerEncuentroUseCaseHandle(ExtraerEncuentroUseCase extraerEncuentroUseCase) {
        this.extraerEncuentroUseCase = extraerEncuentroUseCase;
    }

    @ConsumeEvent(value = "sofkau.oferta.asignarencuentro")
    void consumeBlocking(AsignarEncuentroCommand command) {
        var events = extraerEncuentroUseCase.apply(command);
        saveOferta(command.getOfertaId(), events);
    }


}
