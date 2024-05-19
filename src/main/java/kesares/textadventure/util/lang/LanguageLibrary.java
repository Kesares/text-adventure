package kesares.textadventure.util.lang;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LanguageLibrary {

    private static final String LANG_PATH = "src/main/resources/lang/";

    private final ObjectMapper mapper;
    private final Map<String, Strings> languages;

    public LanguageLibrary(ObjectMapper mapper, Map<String, Strings> languages) {
        this.mapper = mapper;
        this.languages = languages;
        this.loadLanguages();
    }

    private void loadLanguages() {
        try {
            this.languages.put(Language.EN_US.getAbbreviation(), this.mapper.readValue(
                    new File(LANG_PATH + Language.EN_US.getAbbreviation() + ".json"), Strings.class));
            this.languages.put(Language.DE_DE.getAbbreviation(), this.mapper.readValue(
                    new File(LANG_PATH + Language.DE_DE.getAbbreviation() + ".json"), Strings.class));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public Strings getLanguage(Language language) {
        return this.languages.getOrDefault(language.getAbbreviation(), this.languages.get(Language.EN_US.getAbbreviation()));
    }
}
