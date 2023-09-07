package kesares.textadventure.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLibrary {

    private static final ResourceLibrary INSTANCE = new ResourceLibrary(new ResourceLoader());
    private static final String LANG = "lang";
    private static final String LANG_EN = "lang_en";
    private static final String LANG_DE = "lang_de";

    private final ResourceLoader resourceLoader;
    private final Map<String, Properties> langResources;

    private ResourceLibrary(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.langResources = new HashMap<>();
        this.loadResources();
    }

    public static ResourceLibrary getInstance() {
        return INSTANCE;
    }

    private void loadResources() {
        this.langResources.put(LANG, this.resourceLoader.loadPropertiesFrom("/lang/" + LANG + ".properties"));
        this.langResources.put(LANG_EN, this.resourceLoader.loadPropertiesFrom("/lang/" + LANG_EN + ".properties"));
        this.langResources.put(LANG_DE, this.resourceLoader.loadPropertiesFrom("/lang/" + LANG_DE + ".properties"));
    }

    public synchronized Properties getLangResource(String key) {
        return this.langResources.getOrDefault(key, this.langResources.get(LANG));
    }
}