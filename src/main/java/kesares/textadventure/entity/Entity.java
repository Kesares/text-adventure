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

    public Entity(String name, int maxHP, int level, int exp, int gold, int atk, int def, int armor) {
        this.name = name;
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.atk = atk;
        this.def = def;
        this.armor = armor;
    }

    public boolean isAlive() {
        return this.HP > 0;
    }
}