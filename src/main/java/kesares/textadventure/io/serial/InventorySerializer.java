package kesares.textadventure.io.serial;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kesares.textadventure.entity.Inventory;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.util.Utils;

import java.io.IOException;

public class InventorySerializer extends JsonSerializer<Inventory> {

    @Override
    public void serialize(Inventory inventory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeArrayFieldStart("itemStacks");
        for (ItemStack itemStack : inventory.getItemStacks()) {
            if (!Utils.isNotNull(itemStack)) {
                jsonGenerator.writeNull();
                continue;
            }
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("item");

            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("id", itemStack.getItem().getId());
            jsonGenerator.writeEndObject();

            jsonGenerator.writeObjectField("amount", itemStack.getAmount());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
