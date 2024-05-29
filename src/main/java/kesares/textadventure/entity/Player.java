package kesares.textadventure.entity;

import kesares.textadventure.entity.ship.Ship;
import kesares.textadventure.entity.ship.Ships;
import kesares.textadventure.io.OutputManager;
import kesares.textadventure.util.lang.LanguageSelector;

public class Player {

//    private static final int[] REQUIRED_XP_FOR_LEVEL_UP = {15, 24, 34, 43, 53, 63, 72, 82, 92, 101, 111, 121, 130, 140, 149};
//    REQUIRED_XP_FOR_LEVEL_UP[this.level - 1],

    private String name;
    private Ship ship;
    private int level;
    private int exp;
    private long gold;
    private int maxHP;
    private int hp;
    private int cannons;
    private int harpoons;

    public Player(String name) {
        this.name = name;
        this.ship = Ship.Builder.copyOf(Ships.SLOOP);
        this.level = 1;
        this.exp = 0;
        this.gold = 0;
        this.maxHP = this.ship.getHp();
        this.hp = this.maxHP;
        this.cannons += this.ship.getCannons();
        this.harpoons += this.ship.getHarpoons();
    }

    public Player() {
        this("undefined");
    }

    public void printStats() {
        OutputManager.clearConsole();
        OutputManager.printTitle(LanguageSelector.strings.playerStatsTitle + this.name);
        System.out.println(this);
        OutputManager.printBoldPartingLine();
    }

    public void printInventory() {
        OutputManager.printComingSoon("Inventory – ");
    }

//    @Override
//    public void addExp(int exp) {
//        super.addExp(exp);
//        this.checkLevelUp();
//    }
//
//    private void checkLevelUp() {
//        while (this.hasRequiredExpForLevelUp()) {
//            this.level++;
//            this.maxHP++;
//            this.HP++;
////            OutputManager.printTitle(String.format(Strings.levelUp, this.level));
//        }
//    }
//
//    private boolean hasRequiredExpForLevelUp() {
//        return this.exp >= REQUIRED_XP_FOR_LEVEL_UP[this.level - 1];
//    }
//
    @Override
    public String toString() {
        return String.format("Max HP:\t%10d\r\nHP:\t\t%10d\r\nLevel:\t%10d\r\nXP:\t\t%10d/?\r\nGold:\t%10d",
            this.maxHP,
            this.hp,
            this.level,
            this.exp,
            this.gold
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCannons() {
        return cannons;
    }

    public void setCannons(int cannons) {
        this.cannons = cannons;
    }

    public int getHarpoons() {
        return harpoons;
    }

    public void setHarpoons(int harpoons) {
        this.harpoons = harpoons;
    }
}