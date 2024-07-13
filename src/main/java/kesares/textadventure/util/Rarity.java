package kesares.textadventure.util;

public enum Rarity {

    COMMON(AnsiColor.WHITE),
    UNCOMMON(AnsiColor.GREEN),
    RARE(AnsiColor.BLUE),
    EPIC(AnsiColor.PURPLE),
    LEGENDARY(AnsiColor.YELLOW),
    ARTIFACT(AnsiColor.RED);

    private final String color;

    Rarity(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
