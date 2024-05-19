package kesares.textadventure.util.lang;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class LanguageSelector {

    private static final LanguageSelector LANGUAGE_SELECTOR = new LanguageSelector();
    public static Strings strings;

    private final LanguageLibrary languageLibrary;

    private LanguageSelector() {
        this.languageLibrary = new LanguageLibrary(new ObjectMapper(), new HashMap<>());
        this.changeLanguageTo(Language.DE_DE);
    }

    public static LanguageSelector getInstance() {
        return LANGUAGE_SELECTOR;
    }

    public void changeLanguageTo(Language language) {
        strings = this.languageLibrary.getLanguage(language);
    }
}