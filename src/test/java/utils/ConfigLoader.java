package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    FileInputStream fis;
    Properties properties;

    public Properties loadProperties() {
        try {
            fis = new FileInputStream(new File("src/test/resources/config.properties"));
            properties = new Properties();
            properties.load(fis);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties;
    }

    public String getClientId() {
        String prop = properties.getProperty("Client_id");
        if (prop != null) return prop;
        else throw new RuntimeException("Property Client id is not specified in file config.properties");
    }
}

