package kesares.textadventure.io.serial;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import kesares.textadventure.entity.Inventory;
import kesares.textadventure.item.ItemStack;
import kesares.textadventure.item.Items;

import java.io.IOException;

public class InventoryDeserializer extends JsonDeserializer<Inventory> {

    @Override
    public Inventory deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode itemStacksNode = node.get("itemStacks");

        if (itemStacksNode == null || !itemStacksNode.isArray()) return new Inventory("Inventory", Items.ITEMS.size());

        ItemStack[] itemStacks = new ItemStack[itemStacksNode.size()];
        for (int i = 0; i < itemStacksNode.size(); i++) {
            JsonNode itemStackNode = itemStacksNode.get(i);
            if (itemStackNode.get("item") == null) {
                itemStacks[i] = null;
                continue;
            }
            String itemId = itemStackNode.get("item").get("id").asText();
            int itemAmount = itemStackNode.get("amount").asInt();
            itemStacks[i] = new ItemStack(Items.ITEMS.get(itemId), itemAmount);
        }
        return new Inventory("Inventar", itemStacks);
    }
}
