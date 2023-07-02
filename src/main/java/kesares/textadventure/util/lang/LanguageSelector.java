package kesares.textadventure.util.lang;

import kesares.textadventure.util.XMLLoader;

import java.util.Locale;
import java.util.Properties;

public class LanguageSelector {

    private static final LanguageSelector INSTANCE = new LanguageSelector();

    private final XMLLoader xmlLoader;
    private Properties languageProperties;

    private LanguageSelector() {
        this.xmlLoader = XMLLoader.getInstance();
    }

    public static LanguageSelector getInstance() {
        return INSTANCE;
    }

    public void changeLanguageTo(Locale locale) {
        if (locale == Locale.ENGLISH) {
            this.languageProperties = this.xmlLoader.getProperties("Root_en");
        } else if (locale == Locale.GERMAN) {
            this.languageProperties = this.xmlLoader.getProperties("Root_de");
        }
        this.setLanguageResources();
    }

    private void setLanguageResources() {
        Strings.enterContinue = this.languageProperties.getProperty("enterContinue");
        Strings.invalidInput = this.languageProperties.getProperty("invalidInput");
        Strings.optionDoesntExist = Strings.format(this.languageProperties.getProperty("optionDoesntExist"));

        // MenuPrinter-Class
        Strings.mainMenu = Strings.format(this.languageProperties.getProperty("mainMenu"));
        Strings.settingsMenu = Strings.format(this.languageProperties.getProperty("settingsMenu"));
        Strings.settingsMenuTitle = this.languageProperties.getProperty("settingsMenuTitle");
        Strings.langSelectionMenu = Strings.format(this.languageProperties.getProperty("langSelectionMenu"));
        Strings.langSelectionMenuTitle = this.languageProperties.getProperty("langSelectionMenuTitle");
    }
}