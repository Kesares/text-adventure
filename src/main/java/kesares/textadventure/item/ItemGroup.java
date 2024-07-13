package kesares.textadventure.item;

public enum ItemGroup {

    CANNONS("Cannons"),
    HARPOONS("Harpoons"),
    MISCELLANEOUS("Miscellaneous");

    private final String name;

    ItemGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
