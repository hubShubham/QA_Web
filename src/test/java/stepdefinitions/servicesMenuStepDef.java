package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import utils.PropertiesUtils;
import web.WebDriverBase;
import web.pages.PackagePage;
import web.pages.ServicePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Properties;

public class servicesMenuStepDef extends WebDriverBase {
    ServicePage sp=new ServicePage();
    public static PropertiesUtils logoLoad;
    Properties prop=new Properties();


    @Given("Clicks onService catalog and package")
    public void clicks_on_service_catalog_and_package() throws InterruptedException {
        sp.clickCatalogMenu();
    }
    @Given("Clicks on Services menu")
    public void clicks_on_services_menu() {
         sp.clickOnServiceMenu();
    }
    @When("Click on create Servbice button")
    public void click_on_create_servbice_button() throws InterruptedException {
         sp.clickOnCreate();
     }
    @When("User fills {string} {string}, {string}, {string}")
    public void user_fills(String name, String domain, String provider, String logopath) throws InterruptedException {

       CommonMethod cm= new CommonMethod();
       String serviceName=cm.RandomSTring(name);
        sp.fillBasicinfo(serviceName,domain,provider);
     }
    @When("clicks on next")
    public void clicks_on_next() throws InterruptedException {
         sp.clickOnNext();
     }
    @Then("Advanced tab is displayed.")
    public void advanced_tab_is_displayed() {

    }


    @Given("User is on the Advanced tab")
    public void user_is_on_the_advanced_tab() {

    }
    @Then("USer comes on to the use case page")
    public void u_ser_comes_on_to_the_use_case_page() {
      String isUseCaseTrue=sp.findAttributeTrue();
       assertThat(isUseCaseTrue,equalTo("true"));

    }


    @Given("User is on USe case tab")
    public void user_is_on_u_se_case_tab() {
        String isUseCaseTrue=sp.findAttributeTrue();
        assertThat(isUseCaseTrue,equalTo("true"));

    }
    @When("clicks on use case checkbox")
    public void clicks_on_use_case_checkbox() {
         sp.useCaseCheck();
    }
    @Then("user moves onto the configuration tab")
    public void user_moves_onto_the_configuration_tab() {
        String isConfigTrue=sp.findTabTrueForConfi();
        assertThat(isConfigTrue,equalTo("true"));

    }


    @Given("User is on config tab")
    public void user_is_on_config_tab() {
        String isConfigTrue=sp.findTabTrueForConfi();
        assertThat(isConfigTrue,equalTo("true"));

    }

    @Then("user moves onto the actiivation param tab  tab")
    public void user_moves_onto_the_actiivation_param_tab_tab() {
        String isActivationTrue=sp.findActivationTabTrue();
        assertThat(isActivationTrue,equalTo("true"));
    }

    @Then("user moves onto the usage event  tab")
    public void user_moves_onto_the_usage_event_tab() {

        String isUsageTrue=sp.findTrueForUsageTab();
        assertThat(isUsageTrue,equalTo("true"));
    }



    @Given("User is on activation parameter tab")
    public void user_is_on_activation_parameter_tab() {
       String isActivationTrue=sp.findActivationTabTrue();
        assertThat(isActivationTrue,equalTo("true"));
    }




    @Given("User is on usage event tab")
    public void user_is_on_usage_event_tab() {
        String isUsageTrue=sp.findTrueForUsageTab();
        assertThat(isUsageTrue,equalTo("true"));
    }
    @When("clicks on Submit button")
    public void clicks_on_submit_button() throws InterruptedException {
       sp.clickSubmit();
    }
    @Then("user comes back to the service listing grid")
    public void user_comes_back_to_the_service_listing_grid() {

    }




}
