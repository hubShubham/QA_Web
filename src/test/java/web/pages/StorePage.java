package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class StorePage  extends WebDriverBase {
    final private By elem_by_subscription_menu = By.xpath("//span[contains(text(),'Subscriptions & Configurations')]");
    final private By elem_by_Store_menu = By.xpath("//a[@href=\"/outlet\"]");
    final private By elem_Store_searchBox = By.xpath("//input[@formcontrolname=\"merchantName\"]");
    final private By elem_Store_SearchButton = By.xpath("//button[@type=\"submit\"][contains(text(),'Search')]");
    final private By elem_action_button_Store = By.xpath("//span[@class=\"action-icon table-action ng-star-inserted\"]");
    final private By elem_Store_serviceAction_button= By.xpath("//tr[@class=\"ng-star-inserted\"]//td[contains(text(),'Planet DCC Service')]//following-sibling::td//div//span[@title=\"Service Configurations\"]");
    final private By elem_Store_serviceEnableDisableButton= By.xpath("//label[@for=\"customSwitch11\"]");
    final private By elem_Store_OK_button= By.xpath("//button[contains(text(),'Ok')]");
    final private By elem_Store_serviceInfo_Tab= By.xpath("//a[@id=\"ngb-nav-5\"][contains(text(),'Service Info')]");
    final private By elem_Store_Final_Save = By.xpath("//button[contains(text(),'Save')]");
    final private By backdrop_ME = By.className("backdrop");


    public void navigateToStore()
    {
        click(elem_by_subscription_menu);
        click(elem_by_Store_menu);
    }

    public void searchStore(String Storename)
    {
        setText(elem_Store_searchBox,Storename);
        click(elem_Store_SearchButton);
    }

    public void editStore() throws InterruptedException {
        Thread.sleep(3000);
        click(elem_action_button_Store);
    }

    public void goToTabStore() throws InterruptedException {
        Thread.sleep(3000);
        invisibilityForTabs(backdrop_ME,elem_Store_serviceInfo_Tab);
    }

    public void editServiceStore()
    {
        click(elem_Store_serviceAction_button);
    }
    public void serviceEnableDisable() throws InterruptedException {
        click(elem_Store_serviceEnableDisableButton);
        Thread.sleep(2000);
        click(elem_Store_OK_button);
    }

    public void finalSaveforStore() throws InterruptedException {
        scroll(elem_Store_Final_Save);
    }

}
