package Services;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/config.prorepties"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
