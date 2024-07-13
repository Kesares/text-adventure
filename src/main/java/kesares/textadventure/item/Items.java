package kesares.textadventure.item;

public final class Items {

    public static final Item SIX_POUNDER = new Cannon.Settings().id("six_pounder").name("6-Pfünder").itemGroup(ItemGroup.CANNONS).goldCosts(500).build();
    public static final Item NINE_POUNDER = new Cannon.Settings().id("nine_pounder").name("9-Pfünder").itemGroup(ItemGroup.CANNONS).goldCosts(2000).damage(9).scattering(0.7).build();
    public static final Item TEN_POUNDER = new Cannon.Settings().id("ten_pounder").name("10-Pfünder").itemGroup(ItemGroup.CANNONS).diamondCosts(150).damage(9).scattering(0.7).destroyable(false).build();
    public static final Item TWELVE_POUNDER = new Cannon.Settings().id("twelve_pounder").name("12-Pfünder").itemGroup(ItemGroup.CANNONS).diamondCosts(4000).damage(12).scattering(0.6).destroyable(false).build();
    public static final Item EIGHTEEN_POUNDER = new Cannon.Settings().id("eighteen_pounder").name("18-Pfünder").itemGroup(ItemGroup.CANNONS).diamondCosts(6000).damage(15).scattering(0.5).destroyable(false).build();

    private Items() {
        throw new UnsupportedOperationException();
    }
}
