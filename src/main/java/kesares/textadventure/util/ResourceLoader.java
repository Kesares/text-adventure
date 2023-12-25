package kesares.textadventure.util;

import java.io.IOException;
import java.util.Properties;

public final class ResourceLoader {

    private ResourceLoader() {
        throw new UnsupportedOperationException();
    }

    public static Properties loadPropertiesFrom(String path) {
        try {
            Properties properties = new Properties();
            properties.load(ResourceLoader.class.getResourceAsStream(path));
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Error occur loading properties from path: " + path, e);
        }
    }
}