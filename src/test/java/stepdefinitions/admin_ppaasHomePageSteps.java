package stepdefinitions;

public class admin_ppaasHomePageSteps {

 /*   @Given("The homepage {string}")
    public void theHomepage(String url) {
*//*
        WebpageFactory webpageFactory = new WebpageFactory(new WebDriverBase());
        webpageFactory.open_page(url);*//*
    }

    @Then("The search result is displayed")
    public void theSearchResultIsDisplayed() {
    }

    @When("I enter the email {string} on ppaas page")
    public void iEnterTheEmailOnPpaasPage(String email) {
        PpaasHomePage ppaasHomePage = new PpaasHomePage();
        ppaasHomePage.enterEmail(email);
        ppaasHomePage.clickValid();
    }

    @When("I enter the username {string} and password {string} on ppaas login page")
    public void iEnterTheUsernameAndPasswordOnPpaasLoginPage(String username, String password) {
        PpaasLoginPage ppaasLoginPage = new PpaasLoginPage();
        ppaasLoginPage.enterUsername(username);
        ppaasLoginPage.enterPassword(password);
    }*/
}
