package kesares.textadventure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kesares.textadventure.entity.ship.Ship;

public abstract class Entity {

    protected String name;
    protected int maxHP;
    protected int hp;
    protected int level;
    protected int exp;
    protected int gold;
    protected Ship ship;

    public Entity(String name, int level, int exp, int gold, Ship ship) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.maxHP = ship.getHp();
        this.hp = this.maxHP;
        this.ship = ship;
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
}