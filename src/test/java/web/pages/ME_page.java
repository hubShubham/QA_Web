package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class ME_page extends WebDriverBase {


    final private By elem_by_subscription_menu = By.xpath("//span[contains(text(),'Subscriptions & Configurations')]");
    final private By elem_by_ME_menu = By.xpath("//a[@href=\"/merchant-group\"]");
    final private By elem_ME_searchBox = By.xpath("//input[@formcontrolname=\"merchantName\"]");
    final private By elem_ME_Search = By.xpath("//button[@type=\"submit\"][contains(text(),'Search')]");
    final private By elem_action_button_ME = By.xpath("//span[@class=\"action-icon table-action ng-star-inserted\"]");
    final private By elem_ME_serviceAction_button= By.xpath("//td[contains(text(),'Device Management')]/ancestor::tr//td//div//span[@title='Service Configurations']");
    final private By elem_ME_serviceEnableDisableButton= By.xpath("//label[@for=\"customSwitch11\"]");
    final private By elem_ME_OK_button= By.xpath("//button[contains(text(),'Ok')]");
    final private By elem_ME_serviceInfo_Tab= By.xpath("//a[@id=\"ngb-nav-5\"][contains(text(),'Service Info')]");
    final private By elem_ME_Final_Save = By.xpath("//button[contains(text(),'Save')]");
    final private By backdrop_ME = By.className("backdrop");

    public void navigateToME() throws InterruptedException {
        click(elem_by_subscription_menu);
        Thread.sleep(2000);
        click(elem_by_ME_menu);
    }

    public void searchME(String ME_name) throws InterruptedException {

        waitforButtonAndClick(backdrop_ME,elem_ME_searchBox);
        setText(elem_ME_searchBox,ME_name);
        click(elem_ME_Search);
    }

    public void editME() throws InterruptedException {
        Thread.sleep(3000);
        click(elem_action_button_ME);
    }
    public void gToTabME() throws InterruptedException {
        Thread.sleep(5000);
        invisibilityForTabs(backdrop_ME,elem_ME_serviceInfo_Tab);
    }

    public void editServiceME()
    {
        click(elem_ME_serviceAction_button);
    }

    public void enableDisableService() throws InterruptedException {
        click(elem_ME_serviceEnableDisableButton);
        Thread.sleep(3000);
        click(elem_ME_OK_button);
    }

    public void finalSave_ME() throws InterruptedException {
        scroll(elem_ME_Final_Save);
    }


}
