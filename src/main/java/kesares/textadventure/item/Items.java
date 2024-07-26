package kesares.textadventure.item;

import kesares.textadventure.util.Rarity;
import kesares.textadventure.util.lang.LanguageSelector;

import java.util.HashMap;
import java.util.Map;

public final class Items {

    public static final Map<String, Item> ITEMS = new HashMap<>();

    public static final Item SIX_POUNDER = registerItem(new Cannon.Settings().id("six_pounder").name(LanguageSelector.strings.sixPounder).itemGroup(ItemGroup.CANNONS).goldCosts(500).build());
    public static final Item NINE_POUNDER = registerItem(new Cannon.Settings().id("nine_pounder").name(LanguageSelector.strings.ninePounder).itemGroup(ItemGroup.CANNONS).goldCosts(2000).damage(9).scattering(0.7).build());
    public static final Item TEN_POUNDER = registerItem(new Cannon.Settings().id("ten_pounder").name(LanguageSelector.strings.tenPounder).itemGroup(ItemGroup.CANNONS).rarity(Rarity.UNCOMMON).diamondCosts(150).damage(9).scattering(0.7).destroyable(false).build());
    public static final Item TWELVE_POUNDER = registerItem(new Cannon.Settings().id("twelve_pounder").name(LanguageSelector.strings.twelvePounder).itemGroup(ItemGroup.CANNONS).rarity(Rarity.UNCOMMON).diamondCosts(4000).damage(12).scattering(0.6).destroyable(false).build());
    public static final Item EIGHTEEN_POUNDER = registerItem(new Cannon.Settings().id("eighteen_pounder").name(LanguageSelector.strings.eighteenPounder).itemGroup(ItemGroup.CANNONS).rarity(Rarity.UNCOMMON).diamondCosts(6000).damage(15).scattering(0.5).destroyable(false).build());

    public static final Item STONE_BALL = registerItem(new Cannonball.Settings().id("stone_ball").name(LanguageSelector.strings.stoneBall).itemGroup(ItemGroup.CANNONBALLS).goldCosts(10_000).damage(1).criticalHitChance(0.05).criticalHitDamage(0.02).build());
    public static final Item IRON_BALL = registerItem(new Cannonball.Settings().id("iron_ball").name(LanguageSelector.strings.ironBall).itemGroup(ItemGroup.CANNONBALLS).goldCosts(30_000).damage(2).criticalHitChance(0.1).criticalHitDamage(0.02).build());
    public static final Item STEEL_BALL = registerItem(new Cannonball.Settings().id("steel_ball").name(LanguageSelector.strings.steelBall).itemGroup(ItemGroup.CANNONBALLS).rarity(Rarity.UNCOMMON).diamondCosts(1000).damage(10).criticalHitChance(0.15).criticalHitDamage(0.1).build());
    public static final Item STEEL_BALL2 = registerItem(new Cannonball.Settings().id("steel_ball").name(LanguageSelector.strings.steelBall).itemGroup(ItemGroup.CANNONBALLS).rarity(Rarity.UNCOMMON).diamondCosts(1000).damage(10).criticalHitChance(0.15).criticalHitDamage(0.1).build());

    private Items() {
        throw new UnsupportedOperationException();
    }

    public static Item registerItem(Item item) {
        if (ITEMS.containsKey(item.getId())) throw new IllegalArgumentException("Item already registered: " + item.getId());
        ITEMS.put(item.getId(), item);
        return item;
    }
}
