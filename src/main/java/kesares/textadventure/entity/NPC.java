package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;

public class NPC extends Entity {

    public NPC(String name) {
        super(name, 1, 0, 0, Ship.Settings.copyOf(Ships.SLOOP));
    }
}