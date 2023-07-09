package kesares.textadventure.entity;

import kesares.textadventure.util.Maths;

public abstract class Entity {

    protected String name;
    protected int maxHP;
    protected int HP;
    protected int level;
    protected int exp;
    protected int gold;
    protected int atk;
    protected int def;
    protected int armor;

    public Entity(String name, int[] properties) {
        this.name = name;
        this.maxHP = properties[0];
        this.HP = properties[0];
        this.level = properties[1];
        this.exp = properties[2];
        this.gold = properties[3];
        this.atk = properties[4];
        this.def = properties[5];
        this.armor = properties[6];
    }

    public int calculateAtk() {
        return Maths.getRandomNumberBetween(Math.max(this.atk - 2, 0), this.atk + 3);
    }

    public int calculateDef() {
        return (int) (Math.random() * def + this.armor / 30);
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void removeHP(int HP) {
        this.HP -= HP;
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }
}