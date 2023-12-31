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
    public static String battleMenu;

    // Player-Class
    public static String inventoryTitle;
    public static String levelUp;
    public static String playerStatsTitle;

    // Story-Class
    public static String[] invaderNames;
    public static String peacefulJourney;
    public static String storyMenu;

    // Game-Class
    public static String whatIsYourPlayerName;
    public static String playerName;
    public static String playerNameCorrect;
    public static String yesNo;

    // Battle-Class
    public static String beingAttacked;
    public static String runAway;
    public static String makeDamage;
    public static String takeDamage;
    public static String lostBattle;
    public static String defeatedEntity;
    public static String gotXP;
    public static String gotGold;

    private Strings() {
        throw new UnsupportedOperationException();
    }

    public static String[] splitNames(String invaderNames) {
        return invaderNames.split(", ");
    }
}