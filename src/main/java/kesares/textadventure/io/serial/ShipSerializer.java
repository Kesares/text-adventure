package kesares.textadventure.io.serial;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.item.Cannon;

import java.io.IOException;

public class ShipSerializer extends JsonSerializer<Ship> {

    @Override
    public void serialize(Ship ship, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", ship.getId());

        jsonGenerator.writeArrayFieldStart("cannons");
        Cannon[] cannons = ship.getCannons();
        for (Cannon cannon : cannons) {
            jsonGenerator.writeString(cannon.getId());
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
