package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.WebDriverBase;
import web.WebpageFactory;

import web.pages.PpaasLoginPage;
import web.pages.ServicePage;

public class PPaaSLoginPageSteps extends  WebDriverBase {
    PpaasLoginPage login = new PpaasLoginPage();
    ServicePage servicePage = new ServicePage();

    @Given("The homepage {string}")
    public void theHomepage(String url ) {
        WebpageFactory webpageFactory = new WebpageFactory(new WebDriverBase());
        webpageFactory.open_page(url);
    }
    @When("I enter the email {string} on ppaas page and click on Continue button.")
    public void i_enter_the_email_on_ppaas_page_and_click_on_continue_button(String email) {
        login.enterEmailId(email);
        login.clickContineuBtn();
    }
    @When("I enter the username {string} and password {string} on ppaas login page and click on Login button.")
    public void iEnterTheUsernameAndPasswordOnPpaasLoginPageAndClickOnLoginButton(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginBtn();
    }

    @Then("The dashboard page will be displayed")
    public void theDashboardPageWillBeDisplayed() {
    }


}
