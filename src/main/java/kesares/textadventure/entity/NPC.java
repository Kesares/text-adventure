package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.util.Maths;

public class NPC extends Entity {

    private static final String[] NPCS = {"Seeratte", "Williams Garde", "Krebsmonster"};

    private NPC(String name, int level, int exp, int gold) {
        super(name, level, exp, gold, Ship.Settings.copyOf(Ships.SLOOP));
    }

    public static NPC create(int playerLevel) {
        String name = NPCS[(int) (Math.random() * NPCS.length)];
        int level = Maths.getRandomNumberBetween(Math.max(playerLevel - 2, 1), playerLevel + 2);
        int exp = calculateValue(30, 1.5, 20, playerLevel);
        int gold = calculateValue(0, 0.5, 60, playerLevel);
        return new NPC(name, level, exp, gold);
    }

    private static int calculateValue(int base, double rate, double flat, int playerLevel) {
        return (int) Math.round(rate * playerLevel + base + flat);
    }
}