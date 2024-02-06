package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        plugin= {"pretty","json:target/cucumber.json"}
        //tags = "@dev"
)

public class RunCucumberTest {
    @AfterClass
    public static void setup() {
    }
}
