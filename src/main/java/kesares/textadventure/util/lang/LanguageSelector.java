package kesares.textadventure.util.lang;

import kesares.textadventure.util.ResourceLibrary;

import java.util.Properties;

public class LanguageSelector {

    private static final LanguageSelector INSTANCE = new LanguageSelector();

    private final ResourceLibrary resourceLibrary;
    private Properties languageProperties;

    private LanguageSelector() {
        this.resourceLibrary = ResourceLibrary.getInstance();
    }

    public static LanguageSelector getInstance() {
        return INSTANCE;
    }

    public void changeLanguageTo(Language language) {
        switch (language) {
            case ENGLISH -> this.languageProperties = this.resourceLibrary.getLangResource(ResourceLibrary.LANG_EN);
            case GERMAN -> this.languageProperties = this.resourceLibrary.getLangResource(ResourceLibrary.LANG_DE);
        }
        this.setLanguageResources();
    }

    private void setLanguageResources() {
        Strings.enterContinue = this.languageProperties.getProperty("enterContinue");
        Strings.invalidInput = this.languageProperties.getProperty("invalidInput");
        Strings.optionDoesntExist = this.languageProperties.getProperty("optionDoesntExist");

        // MenuPrinter-Class
        Strings.mainMenu = this.languageProperties.getProperty("mainMenu");
        Strings.settingsMenu = this.languageProperties.getProperty("settingsMenu");
        Strings.settingsMenuTitle = this.languageProperties.getProperty("settingsMenuTitle");
        Strings.langSelectionMenu = this.languageProperties.getProperty("langSelectionMenu");
        Strings.langSelectionMenuTitle = this.languageProperties.getProperty("langSelectionMenuTitle");
        Strings.battleMenu = this.languageProperties.getProperty("battleMenu");

        // Player-Class
        Strings.inventoryTitle = this.languageProperties.getProperty("inventoryTitle");
        Strings.levelUp = this.languageProperties.getProperty("levelUp");
        Strings.playerStatsTitle = this.languageProperties.getProperty("playerStatsTitle");

        // Story-Class
        Strings.invaderNames = Strings.splitNames(this.languageProperties.getProperty("invaderNames"));
        Strings.peacefulJourney = this.languageProperties.getProperty("peacefulJourney");
        Strings.storyMenu = this.languageProperties.getProperty("storyMenu");

        // Game-Class
        Strings.whatIsYourPlayerName = this.languageProperties.getProperty("whatIsYourPlayerName");
        Strings.playerName = this.languageProperties.getProperty("playerName");
        Strings.playerNameCorrect = this.languageProperties.getProperty("playerNameCorrect");
        Strings.yesNo = this.languageProperties.getProperty("yesNo");

        // Battle-Class
        Strings.beingAttacked = this.languageProperties.getProperty("beingAttacked");
        Strings.runAway = this.languageProperties.getProperty("runAway");
        Strings.makeDamage = this.languageProperties.getProperty("makeDamage");
        Strings.takeDamage = this.languageProperties.getProperty("takeDamage");
        Strings.lostBattle = this.languageProperties.getProperty("lostBattle");
        Strings.defeatedEntity = this.languageProperties.getProperty("defeatedEntity");
        Strings.gotXP = this.languageProperties.getProperty("gotExp");
        Strings.gotGold = this.languageProperties.getProperty("gotGold");
    }
}