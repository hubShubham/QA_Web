package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class devicePage  extends WebDriverBase {

    final private By elem_by_subscription_menu = By.xpath("//span[contains(text(),'Subscriptions & Configurations')]");
    final private By elem_by_device_menu = By.xpath("//a[@href=\"/pos\"]");
    final private By elem_device_searchBox = By.xpath("//input[@formcontrolname=\"terminalNo\"]");
    final private By elem_device_SearchButton = By.xpath("//button[@type=\"submit\"][contains(text(),'Search')]");
    final private By elem_action_button_device = By.xpath("//span[@class=\"action-icon table-action ng-star-inserted\"]");
    final private By elem_device_serviceAction_button= By.xpath("//tr[@class=\"ng-star-inserted\"]//td[contains(text(),'Planet DCC Service')]//following-sibling::td//div//span[@title=\"Service Configurations\"]");
    final private By elem_device_serviceEnableDisableButton= By.xpath("//label[@for=\"customSwitch11\"]");
    final private By elem_device_OK_button= By.xpath("//button[contains(text(),'Ok')]");
    final private By elem_device_serviceInfo_Tab= By.xpath("//a[@id=\"ngb-nav-4\"][contains(text(),'Service Info')]");
    final private By elem_device_Final_Save = By.xpath("//button[contains(text(),'Save')]");
    final private By backdrop_device = By.className("backdrop");

     public void navigatetoDevice()
     {
         click(elem_by_subscription_menu);
         click(elem_by_device_menu);
     }

     public void searchForDevice(String DeviceId)
     {
         setText(elem_device_searchBox,DeviceId);
         click(elem_device_SearchButton);
     }

     public void editDevice() throws InterruptedException {
         Thread.sleep(3000);
         click(elem_action_button_device);
     }

     public void goToDevicetab() throws InterruptedException {
       Thread.sleep(3000);
       click(elem_device_serviceInfo_Tab);
     }

     public void editServiceforDevice()
     {
         click(elem_device_serviceAction_button);

     }

     public void enableDisableforDevice() throws InterruptedException {
         click(elem_device_serviceEnableDisableButton);

         click(elem_device_OK_button);
     }

     public void finalSaveforDevice() throws InterruptedException {
         scroll(elem_device_Final_Save);
     }

}
