package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.DTMpage;

public class DTMStepsPage extends WebDriverBase {

       DTMpage obj=new DTMpage();

    @Given("User is already logged onto the Admin portal with tenant admin")
    public void user_is_already_logged_onto_the_admin_portal_with_tenant_admin() {

      }
      //General Type Menu
    @When("User naviagtes to Dynamic Terminal Menu")
    public void user_naviagtes_to_dynamic_terminal_menu() {
           obj.navigateToDTM();
    }

    @When("click on Add Dynamic Terminal Menu")
    public void click_on_add_dynamic_terminal_menu() throws InterruptedException {

              obj.addbuttonDTM();
    }
    @When("Fill fields on basic info {string} {string} {string} {string} {string} {string}")
    public void fill_fields_on_basic_info(String tenant, String MAname, String modelType, String menuType, String menuName, String displayArea) throws InterruptedException {

     obj.detailsPage(tenant, MAname, modelType, menuType, menuName, displayArea);
    }
    @When("User clicks on Next button and goes to Preview page")
    public void user_clicks_on_next_button_and_goes_to_preview_page() {

            obj.clickonNext();
    }
    @When("Then saves the page.")
    public void then_saves_the_page() {

             obj.saveDTM();
    }
    @Then("Page gets saved and updated with new Json for Aggreagtor")
    public void page_gets_saved_and_updated_with_new_json_for_aggreagtor() {


     }


    @Then("User downloads the signature schema to verify the updated changes.")
    public void user_downloads_the_signature_schema_to_verify_the_updated_changes() throws InterruptedException {

       obj.signatureFiledownload();
     }

    //Program Specific Menu

    @When("Fill fields on basic info {string} {string} {string} {string} {string} {string}, {string}, {string} {string}")
    public void fill_fields_on_basic_info(String MAname, String modelType, String menuType, String menuName, String displayArea, String serviceDomain,String service, String useCase, String config) throws InterruptedException {
        obj.detailspageProgramSpecific( MAname, modelType, menuType, menuName, displayArea, serviceDomain,service,useCase, config);

    }




}
