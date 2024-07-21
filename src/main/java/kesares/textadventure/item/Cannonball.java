package kesares.textadventure.item;

public class Cannonball extends Item {

    private int damage;
    private double criticalHitChance;
    private double criticalHitDamage;

    private Cannonball(Settings settings) {
        super(settings);
        this.damage = settings.damage;
        this.criticalHitChance = settings.criticalHitChance;
        this.criticalHitDamage = settings.criticalHitDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getCriticalHitChance() {
        return criticalHitChance;
    }

    public void setCriticalHitChance(double criticalHitChance) {
        this.criticalHitChance = criticalHitChance;
    }

    public double getCriticalHitDamage() {
        return criticalHitDamage;
    }

    public void setCriticalHitDamage(double criticalHitDamage) {
        this.criticalHitDamage = criticalHitDamage;
    }

    @Override
    public String toString() {
        return "Cannonball{" +
                super.toString() +
                "damage=" + damage +
                ", criticalHitChance=" + criticalHitChance +
                ", criticalHitDamage=" + criticalHitDamage +
                '}';
    }

    public static class Settings extends Item.Settings<Settings> {

        private int damage;
        private double criticalHitChance;
        private double criticalHitDamage;

        public Settings damage(int damage) {
            if (damage <= 0) throw new IllegalArgumentException("damage must be positive");
            this.damage = damage;
            return this;
        }

        public Settings criticalHitChance(double criticalHitChance) {
            if (criticalHitChance <= 0) throw new IllegalArgumentException("critical hit chance must be positive");
            this.criticalHitChance = criticalHitChance;
            return this;
        }

        public Settings criticalHitDamage(double criticalHitDamage) {
            if (criticalHitDamage <= 0) throw new IllegalArgumentException("critical hit damage must be positive");
            this.criticalHitDamage = criticalHitDamage;
            return this;
        }

        @Override
        protected Settings self() {
            return this;
        }

        @Override
        public Item build() {
            return new Cannonball(this);
        }
    }
}
