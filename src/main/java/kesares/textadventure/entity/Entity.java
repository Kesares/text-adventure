package kesares.textadventure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kesares.textadventure.entity.ship.Ship;

public abstract class Entity {

    protected String name;
    protected Ship ship;
    protected int maxHP;
    protected int hp;
    protected int level;
    protected int exp;
    protected int gold;
    protected int cannons;
    protected int harpoons;

    public Entity(String name, Ship ship, int level, int exp, int gold) {
        this.name = name;
        this.ship = ship;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.maxHP = this.ship.getHp();
        this.hp = this.maxHP;
        this.cannons += this.ship.getCannons();
        this.harpoons += this.ship.getHarpoons();
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

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHP() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void removeHP(int hp) {
        this.hp -= hp;
    }

    @JsonIgnore
    public boolean isAlive() {
        return this.hp > 0;
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

    public void addExp(int exp) {
        this.exp += exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
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