package kesares.textadventure.entity.ship;

import kesares.textadventure.item.Cannon;

public final class Ships {

    public static final Ship SLOOP =  new Ship.Settings().goldCosts(1_000).build();
    public static final Ship BRIGANTINE =  new Ship.Settings().hp(4_500).cannons(new Cannon[20]).harpoons(20).goldCosts(150_000).build();
    public static final Ship WAR_BRIGANTINE =  new Ship.Settings().hp(6_000).cannons(new Cannon[30]).harpoons(30).goldCosts(1_000_000).build();
    public static final Ship FRIGATE =  new Ship.Settings().hp(8_000).cannons(new Cannon[50]).harpoons(40).diamondCosts(25_000).build();
    public static final Ship LARGE_FRIGATE =  new Ship.Settings().hp(12_000).cannons(new Cannon[60]).harpoons(30).diamondCosts(80_000).build();

    private Ships() {
        throw new UnsupportedOperationException();
    }
}
