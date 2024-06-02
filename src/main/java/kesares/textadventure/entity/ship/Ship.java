package kesares.textadventure.entity.ship;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Ship.Settings.class)
public class Ship {

    private final int hp;
    private final int cannons;
    private final int harpoons;
    private final int goldCosts;
    private final int diamondCosts;

    public Ship(Settings settings) {
        this.hp = settings.hp;
        this.cannons = settings.cannons;
        this.harpoons = settings.harpoons;
        this.goldCosts = settings.goldCosts;
        this.diamondCosts = settings.diamondCosts;
    }

    public int getHp() {
        return hp;
    }

    public int getCannons() {
        return cannons;
    }

    public int getHarpoons() {
        return harpoons;
    }

    public int getGoldCosts() {
        return goldCosts;
    }

    public int getDiamondCosts() {
        return diamondCosts;
    }

    public static class Settings {

        private int hp = 2_500;
        private int cannons = 10;
        private int harpoons = 10;
        private int goldCosts = 0;
        private int diamondCosts = 0;

        public static Ship copyOf(Ship ship) {
            return new Settings().hp(ship.hp).cannons(ship.cannons).harpoons(ship.harpoons).goldCosts(ship.goldCosts)
                    .diamondCosts(ship.diamondCosts).build();
        }

        @JsonProperty("hp")
        public Settings hp(int hp) {
            if (hp < 1) throw new IllegalArgumentException("hp < 1");
            this.hp = hp;
            return this;
        }

        @JsonProperty("cannons")
        public Settings cannons(int cannons) {
            if (cannons < 0) throw new IllegalArgumentException("cannons < 0");
            this.cannons = cannons;
            return this;
        }

        @JsonProperty("harpoons")
        public Settings harpoons(int harpoons) {
            if (harpoons < 0) throw new IllegalArgumentException("harpoons < 0");
            this.harpoons = harpoons;
            return this;
        }

        @JsonProperty("goldCosts")
        public Settings goldCosts(int goldCosts) {
            if (goldCosts < 0) throw new IllegalArgumentException("goldCosts < 0");
            this.goldCosts = goldCosts;
            return this;
        }

        @JsonProperty("diamondCosts")
        public Settings diamondCosts(int diamondCosts) {
            if (diamondCosts < 0) throw new IllegalArgumentException("diamondCosts < 0");
            this.diamondCosts = diamondCosts;
            return this;
        }

        public Ship build() {
            return new Ship(this);
        }
    }
}
