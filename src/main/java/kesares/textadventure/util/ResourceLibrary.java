package kesares.textadventure.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLibrary {

    private static final ResourceLibrary INSTANCE = new ResourceLibrary(new ResourceLoader());
    private static final String ROOT = "root";
    private static final String ROOT_EN = "root_en";
    private static final String ROOT_DE = "root_de";

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
        this.langResources.put(ROOT, this.resourceLoader.loadPropertiesFrom("/lang/" + ROOT + ".properties"));
        this.langResources.put(ROOT_EN, this.resourceLoader.loadPropertiesFrom("/lang/" + ROOT_EN + ".properties"));
        this.langResources.put(ROOT_DE, this.resourceLoader.loadPropertiesFrom("/lang/" + ROOT_DE + ".properties"));
    }

    public synchronized Properties getLangResource(String key) {
        return this.langResources.getOrDefault(key, this.langResources.get(ROOT));
    }
}