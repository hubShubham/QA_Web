package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pages.ME_page;

public class MerchantStepdefs {
   ME_page obj =new ME_page();


    @Given("User already logged in on portal")
    public void user_already_logged_in_on_portal() {

     }
    @When("User navigates to the Merchant menu")
    public void user_navigates_to_the_merchant_menu() throws InterruptedException {
      obj.navigateToME();
     }


    @When("User search for the {string} nad click search")
    public void user_search_for_the_nad_click_search(String ME_name) throws InterruptedException {
        obj.searchME(ME_name);

     }
    @When("Edits the MErchant")
    public void edits_the_m_erchant() throws InterruptedException {
      obj.editME();
    }
    @When("click on service info tab")
    public void click_on_service_info_tab() throws InterruptedException {
        obj.gToTabME();
     }
    @When("edits the service")
    public void edits_the_service() {
          obj.editServiceME();
   }
    @When("enable\\/disable the service")
    public void enable_disable_the_service() throws InterruptedException {
         obj.enableDisableService();
    }
    @When("save the changes")
    public void save_the_changes() throws InterruptedException {
           obj.finalSave_ME();
    }
    @Then("MA gets updated")
    public void ma_gets_updated() {

   }


}
