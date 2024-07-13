package kesares.textadventure.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kesares.textadventure.util.Rarity;
import kesares.textadventure.util.Utils;

@JsonDeserialize(builder = Item.Settings.class)
public abstract class Item {

    protected String id;
    protected String name;
    protected Rarity rarity;
    protected ItemGroup itemGroup;
    protected int goldCosts;
    protected int diamondCosts;

    protected Item(Settings<?> settings) {
        this.id = settings.id;
        this.name = settings.name;
        this.rarity = settings.rarity;
        this.itemGroup = settings.itemGroup;
        this.goldCosts = settings.goldCosts;
        this.diamondCosts = settings.diamondCosts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public int getGoldCosts() {
        return goldCosts;
    }

    public int getDiamondCosts() {
        return diamondCosts;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", rarity=" + rarity +
                ", itemGroup=" + itemGroup +
                ", goldCosts=" + goldCosts +
                ", diamondCosts=" + diamondCosts;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Settings<T extends Settings<T>> {

        private String id;
        private String name;
        private Rarity rarity = Rarity.COMMON;
        private ItemGroup itemGroup = ItemGroup.MISCELLANEOUS;
        private int goldCosts = 0;
        private int diamondCosts = 0;

        public T id(String id) {
            if (Utils.isInvalidString(id)) throw new IllegalArgumentException("name is an invalid string");
            this.id = id;
            return this.self();
        }

        public T name(String name) {
            if (Utils.isInvalidString(name)) throw new IllegalArgumentException("name is an invalid string");
            this.name = name;
            return this.self();
        }

        public T rarity(Rarity rarity) {
            if (itemGroup == null) throw new NullPointerException();
            this.rarity = rarity;
            return this.self();
        }

        public T itemGroup(ItemGroup itemGroup) {
            if (itemGroup == null) throw new NullPointerException();
            this.itemGroup = itemGroup;
            return this.self();
        }

        public T goldCosts(int goldCosts) {
            if (goldCosts < 0) throw new IllegalArgumentException("goldCosts < 0");
            this.goldCosts = goldCosts;
            return this.self();
        }

        public T diamondCosts(int diamondCosts) {
            if (diamondCosts < 0) throw new IllegalArgumentException("diamondCosts < 0");
            this.diamondCosts = diamondCosts;
            return this.self();
        }

        protected abstract T self();

        public abstract Item build();
    }
}