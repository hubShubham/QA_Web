package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.pages.PackagePage;

public class PackagePageSteps extends WebDriverBase {
    PackagePage packagePage=new PackagePage();

    @Given("User is logged in a lready")
    public void user_is_logged_in_a_lready() {

    }

    @When("User clicks  Service and catalog Menu and navigate to Package menu")
    public void user_clicks_service_and_catalog_menu_and_navigate_to_package_menu() {

        packagePage.navigateToPackagePage();

     }
    @When("User clicks on add button")
    public void user_clicks_on_add_button() {
         packagePage.clickAddButton_package();

      }


    @When("User Enter the  {string} {string}  {string} {string} {string}")
    public void user_enter_the( String packageCode, String packageName, String publishDate, String region, String country) throws InterruptedException {
       CommonMethod cm= new CommonMethod();
       String packageN= cm.RandomSTring(packageName);
       String code=cm.RandomSTring(packageCode);
        packagePage.addPackage( code, packageN, publishDate, region, country);

    }


    @When("User clicks Next button on basic info page for package")
    public void user_clicks_next_button_on_basic_info_page_for_package() {

    packagePage.clickNextButtonforPackage();

   }

    @Then("User comes onto the List of services tab")
    public void user_comes_onto_the_list_of_services_tab() {


    }

//Sap info tab

    @Given("User is  on SAP info tab")
    public void user_is_on_sap_info_tab() {

     }

     @When("User enters {string}, {string}, {string} {string},{string} {string}")
    public void user_enters(String code_pro, String desc_pro, String code_subs, String desc_subs, String code_usage, String desc_usage) {
        packagePage.sapInfotab(code_pro,desc_pro,code_subs,desc_subs,code_usage,desc_usage);

    }
    @When("User clicks on Next")
    public void user_clicks_on_next() {
    packagePage.clickNextButtonforPackage();
   }


    @Then("User moves to List of Services tab")
    public void user_moves_to_list_of_services_tab() {

     }
//List of Services tab


    @Given("User is   on List of Services tab")
    public void user_is_on_list_of_services_tab() {

     }
    @When("User selects {string} and {string} for taht domain")
    public void user_selects_and_for_taht_domain(String domainName, String serviceName) throws InterruptedException {
    packagePage.listOfServices(domainName,serviceName);
     }
    @When("User clcks on Add to Package button")
    public void user_clcks_on_add_to_package_button() {
      packagePage.AddtopackageButton();
     }
    @Then("User clicks on save button to finally create the package")
    public void user_clicks_on_save_button_to_finally_create_the_package() {
     packagePage.clickSaveButton();

    }



}
