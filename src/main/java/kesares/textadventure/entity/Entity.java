package kesares.textadventure.entity;

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

    public boolean isAlive() {
        return this.HP > 0;
    }

    public int getLevel() {
        return level;
    }
}