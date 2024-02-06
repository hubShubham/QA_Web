package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.issuerProgram;

public class IssuerProgramStepDefs extends WebDriverBase {


    issuerProgram obj=new issuerProgram();

    @Given("User is already logged onto the Admin portal with tenant")
    public void user_is_already_logged_onto_the_admin_portal_with_tenant() {

    }
    @When("User navigates to the Issuer program Menu")
    public void user_navigates_to_the_issuer_program_menu() {
        obj.navigateToIssuerProgram();
    }
    @When("Click on Add Issuer Program button")
    public void click_on_add_issuer_program_button() throws InterruptedException {
        obj.addIssuer();
     }

    @When("Fill fields on basic info  {string}, {string}, {string}, {string}")
    public void fill_fields_on_basic_info(String paymentName, String programName, String type, String status) throws InterruptedException {
        CommonMethod cm= new CommonMethod();
     String program=   cm.RandomSTring(programName);
        obj.fillBasicInfoOfIssuer( paymentName, program, type, status);

    }


    @When("User clicks on Next button on issuer basic info tab")
    public void user_clicks_on_next_button_on_issuer_basic_info_tab() {
         obj.NextbuttonIssuer();
   }

    @Then("User is  moved to Transaction schema tab.")
    public void user_is_moved_to_transaction_schema_tab() {

     }


     // Transaction schema tab

    @Given("User is on the Transaction schema tab")
    public void user_is_on_the_transaction_schema_tab() {

     }
    @When("User selects {string} and {string}")
    public void user_selects_and(String type, String schema) throws InterruptedException {
             obj.trsanctionMapping(type,schema);
    }
    @When("click on Add button")
    public void click_on_add_button() {
             obj.AddMapping();
     }
    @Then("Transaction mapping gets added")
    public void transaction_mapping_gets_added() {
             obj.NextbuttonIssuer();
     }
    @Then("User clicks on Next button for trsnaction and moves onto Program configuration tab")
    public void user_clicks_on_next_button_for_trsnaction_and_moves_onto_program_configuration_tab() {

    }

    // BIN range tab


    @Given("User is  program configuration tab")
    public void user_is_program_configuration_tab() {

    }
    @When("suer clicks on Next button")
    public void suer_clicks_on_next_button() throws InterruptedException {
           Thread.sleep(2000);
           obj.NextbuttonIssuer();
    }
    @Then("On the BIN range tab user fills  {string}, {string}, {string}, {string}, {string}, {string}")
    public void on_the_bin_range_tab_user_fills(String name, String start, String end, String min, String max, String pin) {

        obj.BINdetails(name, start, end, min, max, pin);

    }
    @Then("User clicks on Next button on BIN range tab")
    public void user_clicks_on_next_button_on_bin_range_tab() {
        obj.NextbuttonIssuer();
   }
    @Then("On preview tab clicks on save button")
    public void on_preview_tab_clicks_on_save_button() throws InterruptedException {
        obj.saveIssuer();
   }
    @Then("Issuer program gets saved.")
    public void issuer_program_gets_saved() {

  }




}
