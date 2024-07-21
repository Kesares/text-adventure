package kesares.textadventure.entity.ship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kesares.textadventure.item.Cannon;
import kesares.textadventure.item.Items;

import java.util.Arrays;

@JsonDeserialize(builder = Ship.Settings.class)
public class Ship {

    private final int hp;
    private final int goldCosts;
    private final int diamondCosts;
    private final Cannon[] cannons;

    private Ship(Settings settings) {
        this.hp = settings.hp;
        this.goldCosts = settings.goldCosts;
        this.diamondCosts = settings.diamondCosts;
        this.cannons = settings.cannons;
    }

    public int getHp() {
        return hp;
    }

    public int getGoldCosts() {
        return goldCosts;
    }

    public int getDiamondCosts() {
        return diamondCosts;
    }

    public Cannon[] getCannons() {
        return cannons;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Settings {

        private int hp = 2_500;
        private int goldCosts = 0;
        private int diamondCosts = 0;
        private Cannon[] cannons = new Cannon[10];

        public static Ship copyOf(Ship ship) {
            return new Settings().hp(ship.hp).goldCosts(ship.goldCosts).diamondCosts(ship.diamondCosts)
                    .cannons(ship.cannons).build();
        }

        public Settings hp(int hp) {
            if (hp < 1) throw new IllegalArgumentException("hp < 1");
            this.hp = hp;
            return this;
        }

        public Settings goldCosts(int goldCosts) {
            if (goldCosts < 0) throw new IllegalArgumentException("goldCosts < 0");
            this.goldCosts = goldCosts;
            return this;
        }

        public Settings diamondCosts(int diamondCosts) {
            if (diamondCosts < 0) throw new IllegalArgumentException("diamondCosts < 0");
            this.diamondCosts = diamondCosts;
            return this;
        }

        public Settings cannons(Cannon[] cannons) {
            if (cannons == null) throw new NullPointerException();
            this.cannons = cannons;
            return this;
        }

        public Ship build() {
            Arrays.fill(this.cannons, Items.SIX_POUNDER);
            return new Ship(this);
        }
    }
}
