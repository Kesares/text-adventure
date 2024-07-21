package kesares.textadventure.item;

public enum ItemGroup {

    CANNONS("Cannons"),
    HARPOONS("Harpoons"),
    CANNONBALLS("Cannonballs"),
    MISCELLANEOUS("Miscellaneous");

    private final String name;

    ItemGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
