package kesares.textadventure.item;

public class Item {

    private final String ID;
    private String name;

    public Item(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}