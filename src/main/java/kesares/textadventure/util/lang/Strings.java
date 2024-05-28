package kesares.textadventure.util.lang;

public final class Strings {

    public static final String COMING_SOON = "Coming soon...";

    public String back;
    public String createNewPlayer;
    public String createNewWorld;
    public String deleted;
    public String enterToContinue;
    public String enterWorldName;
    public String invalidInput;
    public String invalidPlayerName;
    public String invalidWorldName;
    public String languageSelectionMenu;
    public String languageSelectionMenuTitle;
    public String savedWorldsTitle;
    public String mainMenu;
    public String numero;
    public String optionDoesntExist;
    public String playerName;
    public String settingsMenu;
    public String settingsMenuTitle;
    public String worlds;
    public String worldMenu;
    public String worldSelectionMenu;
    public String yesNo;

//    public String battleMenu;
//    public String inventoryTitle;
//    public String levelUp;
//    public String playerStatsTitle;
//    public String[] invaderNames;
//    public String peacefulJourney;
//    public String whatIsYourPlayerName;
//    public String playerNameCorrect;
//    public String beingAttacked;
//    public String runAway;
//    public String makeDamage;
//    public String takeDamage;
//    public String lostBattle;
//    public String defeatedEntity;
//    public String gotXP;
//    public String gotGold;

    public String getFormattedOptionDoesntExist(int option) {
        return String.format(this.optionDoesntExist, option);
    }
}