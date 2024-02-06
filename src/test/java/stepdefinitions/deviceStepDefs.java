package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pages.devicePage;

public class deviceStepDefs {

    devicePage obj=new devicePage();


    @Given("User is already logged in admin portal with tenant")
    public void user_is_already_logged_in_admin_portal_with_tenant() {


    }
    @When("User navigates to Device")
    public void user_navigates_to_device() {
          obj.navigatetoDevice();
    }
    @When("User search for {string} on Device menu")
    public void user_search_for_on_device_menu(String DeviceId) {
           obj.searchForDevice(DeviceId);
   }
    @When("user edits device.")
    public void user_edits_device() throws InterruptedException {
       obj.editDevice();

     }
    @When("USer goes to service info tab")
    public void u_ser_goes_to_service_info_tab() throws InterruptedException {
          obj.goToDevicetab();

    }
    @When("User edits a service for device")
    public void user_edits_a_service_for_device() {
            obj.editServiceforDevice();

    }
    @When("User enables or disables a service and click ok")
    public void user_enables_or_disables_a_service_and_click_ok() throws InterruptedException {

         obj.enableDisableforDevice();
    }
    @When("Finally saves the Device changes")
    public void finally_saves_the_device_changes() throws InterruptedException {

       obj.finalSaveforDevice();
    }
    @Then("Device gest updated.")
    public void device_gest_updated() {


   }

}
