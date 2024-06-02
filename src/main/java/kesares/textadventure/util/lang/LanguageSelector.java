package kesares.textadventure.util.lang;

import kesares.textadventure.util.ResourceLibrary;

public class LanguageSelector {

    private static final LanguageSelector LANGUAGE_SELECTOR = new LanguageSelector();
    public static Strings strings;

    private LanguageSelector() {
        this.changeLanguageTo(Language.DE_DE);
    }

    public static LanguageSelector getInstance() {
        return LANGUAGE_SELECTOR;
    }

    public void changeLanguageTo(Language language) {
        strings = ResourceLibrary.getLanguage(language);
    }
}