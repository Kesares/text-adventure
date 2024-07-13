package kesares.textadventure.item;

public final class Items {

    public static final Item SIX_POUNDER = new Cannon.Settings().id("six_pounder").name("6-Pfünder").itemGroup(ItemGroup.CANNONS).goldCosts(500).damage(6).scattering(0.8).destroyable(true).build();

    private Items() {
        throw new UnsupportedOperationException();
    }
}
