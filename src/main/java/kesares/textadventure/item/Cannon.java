package kesares.textadventure.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Cannon.Settings.class)
public class Cannon extends Item {

    private final int damage;
    private final double scattering;
    private final boolean isDestroyable;

    private Cannon(Settings settings) {
        super(settings);
        this.damage = settings.damage;
        this.scattering = settings.scattering;
        this.isDestroyable = settings.isDestroyable;
    }

    public int getDamage() {
        return damage;
    }

    public double getScattering() {
        return scattering;
    }

    public boolean isDestroyable() {
        return isDestroyable;
    }

    @Override
    public String toString() {
        return "Cannon{" +
                super.toString() +
                "damage=" + damage +
                ", scattering=" + scattering +
                ", isDestroyable=" + isDestroyable +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Settings extends Item.Settings<Settings> {

        private int damage = 6;
        private double scattering = 0.8;
        private boolean isDestroyable = true;

        public Settings damage(int damage) {
            if (damage <= 0) throw new IllegalArgumentException("damage must be positive");
            this.damage = damage;
            return this;
        }

        public Settings scattering(double scattering) {
            if (scattering <= 0) throw new IllegalArgumentException("scattering must be positive");
            this.scattering = scattering;
            return this;
        }

        public Settings destroyable(boolean destroyable) {
            this.isDestroyable = destroyable;
            return this;
        }

        @Override
        protected Settings self() {
            return this;
        }

        public Cannon build() {
            return new Cannon(this);
        }
    }
}
