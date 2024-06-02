package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;

public class NPC extends Entity {

    public NPC(String name) {
        super(name, Ship.Settings.copyOf(Ships.SLOOP), 1, 0, 0);
    }
}