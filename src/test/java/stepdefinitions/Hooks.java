package stepdefinitions;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import reusableClass.Routes;
import utils.PropertiesUtils;
import utils.SslConfigUtils;

import java.util.Properties;
import java.util.logging.Logger;

public class Hooks extends Commons {

   // public static final Logger logger = Logger.getLogger(Hooks.class);
    static Properties property = new Properties();

   // @Before()
    public static void initTest() {

        property = PropertiesUtils.loadProperties();

       // SslConfigUtils.initConfig(property);

        RestAssured.baseURI = property.getProperty("base.uri");
       // RestAssured.baseURI = property.getProperty(Routes.BASE_URI);

    }

    @After
    public void afterScenario(Scenario scenario) {

        // WebDriverBase.quitDriver();
     //   logger.info("web driver is closed");
    }
}
