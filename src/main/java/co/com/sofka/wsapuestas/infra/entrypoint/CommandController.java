package co.com.sofka.wsapuestas.infra.entrypoint;


import co.com.sofka.wsapuestas.domain.oferta.command.AsignarEncuentroCommand;
import co.com.sofka.wsapuestas.domain.oferta.command.CrearOfertaCommand;
import io.vertx.mutiny.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class CommandController {

    private final EventBus bus;

    public CommandController(EventBus bus) {
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crearOferta")
    public Response executor(CrearOfertaCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/asignarEncuentro")
    public Response executor(AsignarEncuentroCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }


}