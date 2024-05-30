package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;

public class Invader extends Entity {

    public Invader() {
        super("Invader", Ship.Builder.copyOf(Ships.SLOOP), 1, 0, 0);
    }
}