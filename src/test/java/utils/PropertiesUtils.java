package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils() {
        throw new IllegalStateException("Use of default constructor is forbidden");
    }
    public static Properties loadProperties() {

        var prop = new Properties();
        var environment = System.getProperty("env");

        if (environment == null) {
            environment = "ppaas.int";


        }

        var filePath = environment + ".properties";
        System.out.println("The file path is " + environment);

        try (InputStream resourceAsStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;
    }
}
