package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.MApage;

public class MAmenustepdefs extends WebDriverBase {
 MApage obj = new MApage();



    @Given("User is logged in already")
    public void user_is_logged_in_already() {

    }

          @When("User clicks on Subscription & Configuration Menu and navigate to MA menu")
          public void user_clicks_on_subscription_configuration_menu_and_navigate_to_ma_menu() {
           obj.navigate_to_MA();

          }

          @When("User  search for {string} and edits the MA")
          public void user_search_for_and_edits_the_ma(String MA_name) throws InterruptedException {

           obj.search_MA(MA_name);
           obj.editMA();
          }


          @When("User clicks on service Info tab")
          public void user_clicks_on_service_info_tab() throws InterruptedException {
           obj.goToTab();
          }

          @When("User edits a service thorugh action button")
          public void user_edits_a_service_thorugh_action_button() throws InterruptedException {
           obj.editservice();
          }

          @When("User  disables the service and clicks on ok")
          public void user_disables_the_service_and_clicks_on_ok() throws InterruptedException {
           obj.enableDisableService();
          }

          @When("Finally saves the MA")
          public void finally_saves_the_ma() throws InterruptedException {

           obj.clickFinalsave();
          }


          @Then("{string} gets updated successfully")
          public void gets_updated_successfully(String MA_name) throws InterruptedException {


          }

}

