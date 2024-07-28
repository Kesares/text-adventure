package kesares.textadventure.io.serial;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.item.Cannon;
import kesares.textadventure.item.Item;
import kesares.textadventure.item.Items;

import java.io.IOException;
import java.util.Iterator;

public class ShipDeserializer extends JsonDeserializer<Ship> {

    @Override
    public Ship deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Cannon[] cannons = new Cannon[node.get("cannons").size()];

        JsonNode cannonsNode = node.get("cannons");
        if (cannonsNode != null && cannonsNode.isArray()) {
            Iterator<JsonNode> elements = cannonsNode.elements();
            int i = 0;
            while (elements.hasNext()) {
                JsonNode cannonIdNode = elements.next();
                String cannonId = cannonIdNode.asText();
                Item cannonItem = Items.ITEMS.get(cannonId);
                if (cannonItem instanceof Cannon cannon) {
                    cannons[i++] = cannon;
                }
            }
        }
        Ship ship = Ship.Settings.copyOf(Ships.SHIPS.get(node.get("id").asText()));
        ship.setCannons(cannons);
        return ship;
    }
}
