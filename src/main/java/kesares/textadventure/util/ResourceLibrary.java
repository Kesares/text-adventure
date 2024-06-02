package kesares.textadventure.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import kesares.textadventure.Main;
import kesares.textadventure.core.Build;
import kesares.textadventure.util.lang.Language;
import kesares.textadventure.util.lang.Strings;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResourceLibrary {

    private static final String ABSOLUTE_JAR_FILE_PATH = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    private static final String LANG_PATH = "src/main/resources/lang/";
    private static final Map<String, Strings> LANGUAGES = new HashMap<>();

    private ResourceLibrary() {
        throw new UnsupportedOperationException();
    }

    public static void init() {
        if (Build.IS_RUNNING_IN_PRODUCTION_MODE) {
            loadLanguagesFromJar();
        } else {
            loadLanguagesFromIDE();
        }
    }

    private static void loadLanguagesFromJar() {
        System.out.println(ABSOLUTE_JAR_FILE_PATH);
    }

    private static void loadLanguagesFromIDE() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            LANGUAGES.put(Language.EN_US.getAbbreviation(), mapper.readValue(
                    new File(LANG_PATH + Language.EN_US.getAbbreviation() + ".json"), Strings.class));
            LANGUAGES.put(Language.DE_DE.getAbbreviation(), mapper.readValue(
                    new File(LANG_PATH + Language.DE_DE.getAbbreviation() + ".json"), Strings.class));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static Strings getLanguage(Language language) {
        return LANGUAGES.getOrDefault(language.getAbbreviation(), LANGUAGES.get(Language.EN_US.getAbbreviation()));
    }
}
