package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;

public class Integrationstepdefs  {

   PackagePageSteps obj=new PackagePageSteps();

    @Given("User is logged in on portal")
    public void user_is_logged_in_on_portal() {

    }
    @When("User is on package menu and creates package.")
    public void user_is_on_package_menu_and_creates_package() {

        obj.user_clicks_service_and_catalog_menu_and_navigate_to_package_menu();
        obj.user_clicks_on_add_button();
      //  obj.user_enter_the();



    }
    @When("Pricing menu")
    public void pricing_menu() {

    }
    @When("Moves to Merchant Aggregator menu")
    public void moves_to_merchant_aggregator_menu() {

     }
    @When("User now on Merchant menu")
    public void user_now_on_merchant_menu() {

    }
    @When("Store Menu")
    public void store_menu() {

    }
    @When("Logical Device")
    public void logical_device() {

   }
    @When("Issuer program")
    public void issuer_program() {

    }
    @When("Dynamic Terminal menu")
    public void dynamic_terminal_menu() {

    }
    @Then("Flow stops")
    public void flow_stops() {

     }


}
