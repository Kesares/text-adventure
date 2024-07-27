package kesares.textadventure.item;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CannonSerializer extends JsonSerializer<Cannon> {

    @Override
    public void serialize(Cannon cannon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(cannon.getId());
    }
}
