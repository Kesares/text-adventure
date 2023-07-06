package kesares.textadventure.util.lang;

public final class Strings {

    public static String enterContinue;
    public static String invalidInput;
    public static String optionDoesntExist;

    // MenuPrinter-Class
    public static String mainMenu;
    public static String settingsMenu;
    public static String settingsMenuTitle;
    public static String langSelectionMenu;
    public static String langSelectionMenuTitle;

    // Player-Class
    public static String playerStatsTitle;
    public static String inventoryTitle;

    // Story-Class
    public static String storyMenu;
    public static String peacefulJourney;

    // Game-Class
    public static String whatIsYourPlayerName;
    public static String playerName;
    public static String playerNameCorrect;
    public static String yesNo;

    private Strings() {
        throw new UnsupportedOperationException();
    }

    public static String format(String text) {
        return text.replaceAll("\\|", "\r\n");
    }
}