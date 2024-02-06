package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.StorePage;

public class StoreStepDefs extends WebDriverBase {

  StorePage obj =new StorePage();

    @Given("User is already logged into the admin portal")
    public void user_is_already_logged_into_the_admin_portal() {
      }
    @When("User navigates to the store menu")
    public void user_navigates_to_the_store_menu() {
     obj.navigateToStore();
    }




    @When("User search for {string} and click Search")
    public void user_search_for_and_click_search(String StoreName) {
         obj.searchStore(StoreName);
       }


    @When("User edits store")
    public void user_edits_store() throws InterruptedException {
        obj.editStore();
    }
    @When("Moves to service info tab")
    public void moves_to_service_info_tab() throws InterruptedException {
          obj.goToTabStore();
    }
    @When("Edits service")
    public void edits_service() {
          obj.editServiceStore();
    }
    @When("Enables or disables the service and click on ok")
    public void enables_or_disables_the_service_and_click_on_ok() throws InterruptedException {
          obj.serviceEnableDisable();
    }
    @When("Finally saves the Store changes")
    public void finally_saves_the_store_changes() throws InterruptedException {
          obj.finalSaveforStore();
   }
    @Then("Store gets updated")
    public void store_gets_updated() {

   }


}
