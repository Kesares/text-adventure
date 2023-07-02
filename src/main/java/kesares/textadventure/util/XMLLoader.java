package kesares.textadventure.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class XMLLoader {

    private static final XMLLoader INSTANCE = new XMLLoader();

    private final Map<String, Properties> properties;

    private XMLLoader() {
        this.properties = Map.of(
            // "Root", this.getPropertiesFrom("/lang/Root.xml"),
            "Root_en", this.getPropertiesFrom("/lang/Root_en.xml"),
            "Root_de", this.getPropertiesFrom("/lang/Root_de.xml")
        );
    }

    public static XMLLoader getInstance() {
        return INSTANCE;
    }

    private Properties getPropertiesFrom(String path) {
        Properties properties = new Properties();
        try {
            InputStream stream = loadResource(path);
            if (!Maths.isNull(stream)) properties.loadFromXML(stream);
            else throw new IllegalArgumentException("Failed to load resource: " + path);
        } catch (IOException e) {
            throw new RuntimeException("Error occur loading XML properties from: " + path, e);
        }
        return properties;
    }

    private InputStream loadResource(String path) {
        return XMLLoader.class.getResourceAsStream(path);
    }

    public synchronized Properties getProperties(String key) {
        return this.properties.getOrDefault(key, this.properties.get("Root"));
    }
}