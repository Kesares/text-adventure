package kesares.textadventure.entity.ship;

import kesares.textadventure.item.Cannon;

import java.util.HashMap;
import java.util.Map;

public final class Ships {

    public static final Map<String, Ship> SHIPS = new HashMap<>();

    public static final Ship SLOOP = registerShip(new Ship.Settings().id("sloop").goldCosts(1_000).build());
    public static final Ship BRIGANTINE = registerShip(new Ship.Settings().id("brigantine").hp(4_500).cannons(new Cannon[20]).goldCosts(150_000).build());
    public static final Ship WAR_BRIGANTINE = registerShip(new Ship.Settings().id("war_brigantine").hp(6_000).cannons(new Cannon[30]).goldCosts(1_000_000).build());
    public static final Ship FRIGATE = registerShip(new Ship.Settings().id("frigate").hp(8_000).cannons(new Cannon[50]).diamondCosts(25_000).build());
    public static final Ship LARGE_FRIGATE = registerShip(new Ship.Settings().id("large_frigate").hp(12_000).cannons(new Cannon[60]).diamondCosts(80_000).build());

    private Ships() {
        throw new UnsupportedOperationException();
    }

    public static Ship registerShip(Ship ship) {
        if (SHIPS.containsKey(ship.getId())) throw new IllegalArgumentException("Ship already registered: " + ship.getId());
        SHIPS.put(ship.getId(), ship);
        return ship;
    }
}
