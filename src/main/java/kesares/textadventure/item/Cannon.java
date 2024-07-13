package kesares.textadventure.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Cannon.Settings.class)
public class Cannon extends Item {

    private int damage;
    private double scattering;
    private boolean isDestroyable;

    protected Cannon(Settings settings) {
        super(settings);
        this.damage = settings.damage;
        this.scattering = settings.scattering;
        this.isDestroyable = settings.isDestroyable;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getScattering() {
        return scattering;
    }

    public void setScattering(double scattering) {
        this.scattering = scattering;
    }

    public boolean isDestroyable() {
        return isDestroyable;
    }

    public void setDestroyable(boolean isDestroyable) {
        this.isDestroyable = isDestroyable;
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

        private int damage;
        private double scattering;
        private boolean isDestroyable;

        public Settings damage(int damage) {
            this.damage = damage;
            return this;
        }

        public Settings scattering(double scattering) {
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
