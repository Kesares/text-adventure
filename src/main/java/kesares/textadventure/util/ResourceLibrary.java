package kesares.textadventure.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLibrary {

    public static final String LANG_EN = "lang_en";
    public static final String LANG_DE = "lang_de";

    private static final ResourceLibrary INSTANCE = new ResourceLibrary();

    private final Map<String, Properties> langResources;

    private ResourceLibrary() {
        this.langResources = new HashMap<>();
        this.loadResources();
    }

    public static ResourceLibrary getInstance() {
        return INSTANCE;
    }

    private void loadResources() {
        this.langResources.put(LANG_EN, ResourceLoader.loadPropertiesFrom("/lang/" + LANG_EN + ".properties"));
        this.langResources.put(LANG_DE, ResourceLoader.loadPropertiesFrom("/lang/" + LANG_DE + ".properties"));
    }

    public synchronized Properties getLangResource(String key) {
        return this.langResources.getOrDefault(key, this.langResources.get(LANG_EN));
    }
}