package kesares.textadventure.entity;

import kesares.textadventure.util.Adjust;
import kesares.textadventure.util.Maths;

public class Invader extends Entity {

    @Adjust
    public Invader(String name, int playerLevel) {
        super(name, new int[] {0, 0, 0, 0, 0, 0, 0});
        int[] properties = this.calculateInvaderProperties(playerLevel);
        this.maxHP = properties[0];
        this.HP = properties[0];
        this.level = properties[1];
        this.exp = properties[2];
        this.gold = properties[3];
        this.atk = properties[4];
        this.def = properties[5];
        this.armor = properties[6];
    }

    private int[] calculateInvaderProperties(int playerLevel) {
        final int maxHP = this.calculateValue(10, 0.15, 7, playerLevel);
        final int level = Maths.getRandomNumberBetween(Math.max(playerLevel - 2, 1), playerLevel + 2);
        final int exp = this.calculateValue((int) (Math.random() * 3 + 1), 0.43, 3.19, playerLevel);
        final int gold = this.calculateValue((int) (Math.random() * 5 + 3), 0.15, 10, playerLevel);
        final int atk = this.calculateValue(1, 0.05, 0.5, playerLevel);
        final int def = this.calculateValue(0, 0.05, 0.5, playerLevel);
        final int armor = this.calculateValue(0, 0.03, 0.7, playerLevel);
        return new int[] {maxHP, level, exp, gold, atk, def, armor};
    }

    private int calculateValue(int base, double rate, double flat, int playerLevel) {
        return (int) Math.round(base * (1 + (playerLevel - 1) * rate) + (flat * (playerLevel - 1)));
    }
}