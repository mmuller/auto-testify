package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private Properties properties;

    public PropertyLoader() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("credentials.properties")) {
            if (inputStream == null) {
                throw new IOException("Properties file cannot be found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(int index) {
        return properties.getProperty("user" + index + ".username");
    }

    public String getPassword(int index) {
        return properties.getProperty("user" + index + ".password");
    }

    public String getInvalidUsername(int index) {
        return properties.getProperty("invalidUser" + index + ".username");
    }

    public String getInvalidPassword(int index) {
        return properties.getProperty("invalidUser" + index + ".password");
    }

    public String getErrorMessage(int index) {
        return properties.getProperty("invalidUser" + index + ".errorMessage");
    }
}
