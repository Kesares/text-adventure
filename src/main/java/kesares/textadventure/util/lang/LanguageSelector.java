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
        Strings.optionDoesntExist = this.languageProperties.getProperty("optionDoesntExist");
    }
}