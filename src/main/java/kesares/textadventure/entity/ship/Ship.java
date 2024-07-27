package kesares.textadventure.entity.ship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kesares.textadventure.item.Cannon;
import kesares.textadventure.item.Items;
import kesares.textadventure.util.Utils;

import java.util.Arrays;

@JsonDeserialize(using = ShipDeserializer.class)
@JsonSerialize(using = ShipSerializer.class)
public class Ship {

    private final String id;
    private final int hp;
    private final int goldCosts;
    private final int diamondCosts;
    private Cannon[] cannons;

    private Ship(Settings settings) {
        this.id = settings.id;
        this.hp = settings.hp;
        this.goldCosts = settings.goldCosts;
        this.diamondCosts = settings.diamondCosts;
        this.cannons = settings.cannons;
    }

    public String getId() {
        return id;
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

    public void setCannons(Cannon[] cannons) {
        this.cannons = cannons;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id='" + id + '\'' +
                ", hp=" + hp +
                ", goldCosts=" + goldCosts +
                ", diamondCosts=" + diamondCosts +
                ", cannons=" + Arrays.toString(cannons) +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Settings {

        private String id;
        private int hp = 2_500;
        private int goldCosts = 0;
        private int diamondCosts = 0;
        private Cannon[] cannons = new Cannon[10];

        public static Ship copyOf(Ship ship) {
            return new Settings().id(ship.id).hp(ship.hp).goldCosts(ship.goldCosts).diamondCosts(ship.diamondCosts)
                    .cannons(ship.cannons).build();
        }

        public Settings id(String id) {
            if (Utils.isInvalidString(id)) throw new IllegalArgumentException("id is an invalid string");
            this.id = id;
            return this;
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
