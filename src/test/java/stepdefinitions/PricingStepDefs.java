package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.Pricing;

public class PricingStepDefs extends WebDriverBase {


    Pricing obj =new Pricing();

        @Given("User is already logged in to the Tenant portal")
        public void user_is_already_logged_in_to_the_tenant_portal() {

          }
        @When("User clicks on Pricing Menu under Services, Catalog and packages.")
        public void user_clicks_on_pricing_menu_under_services_catalog_and_packages() {
                 obj.naviagteToPricingGrid();
          }
        @When("User clicks on Add Pricing button the pricing Page.")
        public void user_clicks_on_add_pricing_button_the_pricing_page() {
                 obj.clickOnAddPricing();
        }


        @When("User fills basic info page: {string} , {string}, {string} , {string}, {string},")
        public void user_fills_basic_info_page(String tenantname, String pricingName, String type, String packages, String date) throws InterruptedException {
                 obj.basicInfofieldsPriing(tenantname, pricingName, type, packages, date);
        }
        @When("User clicks on Next button")
        public void user_clicks_on_next_button() {
                 obj.clickOnNext();
        }
        @Then("User is moved to the Package Pricing tab.")
        public void user_is_moved_to_the_package_pricing_tab() {

         }


         //PackagePricing tab




    @Given("User is on the package pricing tab")
    public void user_is_on_the_package_pricing_tab() {

    }
    @When("user selects {string} and fills {string} and also selects {string} and fills {string}")
    public void user_selects_and_fills_and_also_selects_and_fills(String setupDrop, String setupValue, String subsDrop, String subsValue) throws InterruptedException {
               obj.packagePricingTab(setupDrop,setupValue,subsDrop,subsValue);
     }
    @When("Clicks on save")
    public void clicks_on_save() {
           obj.finalSavePricing();
    }
    @Then("Pricing is created")
    public void pricing_is_created() {

      }


}
