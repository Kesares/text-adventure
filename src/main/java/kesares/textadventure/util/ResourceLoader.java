package kesares.textadventure.util;

import java.io.IOException;
import java.util.Properties;

public class ResourceLoader {

    public Properties loadPropertiesFrom(String path) {
        Properties properties = new Properties();
        try {
            properties.load(ResourceLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException("Error occur loading properties from path: " + path, e);
        }
        return properties;
    }
}