package kesares.textadventure.util.lang;

public final class Strings {

    public static final String COMING_SOON = "Coming soon...";

    public String back;
    public String battleMenu;
    public String beingAttacked;
    public String createNewPlayer;
    public String createNewWorld;
    public String defeatedEntity;
    public String deleted;
    public String enterToContinue;
    public String enterWorldName;
    public String flee;
    public String gotGold;
    public String gotExp;
    public String invalidInput;
    public String invalidPlayerName;
    public String invalidWorldName;
    public String languageSelectionMenu;
    public String languageSelectionMenuTitle;
    public String lostBattle;
    public String savedWorldsTitle;
    public String mainMenu;
    public String makeDamage;
    public String numero;
    public String optionDoesntExist;
    public String peacefulJourney;
    public String playerName;
    public String playerStatsTitle;
    public String settingsMenu;
    public String settingsMenuTitle;
    public String takeDamage;
    public String worlds;
    public String worldMenu;
    public String worldSelectionMenu;
    public String yesNo;

//    public String levelUp;
//    public String[] invaderNames;

    public String getFormattedOptionDoesntExist(int option) {
        return String.format(this.optionDoesntExist, option);
    }
}