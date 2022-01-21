package co.com.sofka.wsapuestas.infra.materialize;

import co.com.sofka.wsapuestas.domain.oferta.event.EncuentroAsignado;
import co.com.sofka.wsapuestas.domain.oferta.event.OfertaCreada;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class OfertaHandle {

    private final MongoClient mongoClient;

    public OfertaHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @ConsumeEvent(value = "sofkau.oferta.ofertacreada", blocking = true)
    void consumeOfertaCreada(OfertaCreada event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getNombre());

        mongoClient.getDatabase("queries")
                .getCollection("oferta")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.oferta.encuentroasignado", blocking = true)
    void consumeCourseAssigned(EncuentroAsignado event) {
        BasicDBObject document = new BasicDBObject();
        var key = "encuentros."+event.getLocal().concat(" - ").concat(event.getVisitante());
        document.put(key+".local", event.getLocal());
        document.put(key+".visitante", event.getVisitante());
        document.put(key+".apuestas", event.getApuestas());
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries")
                .getCollection("oferta")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

}