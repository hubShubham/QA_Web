package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class MApage extends WebDriverBase {



    final private By elem_by_subscription_menu = By.xpath("//span[contains(text(),'Subscriptions & Configurations')]");
    final private By elem_by_MA_menu = By.xpath("//a[contains(text(),'Merchant Aggregator')]");
    final private By elem_MA_searchBox = By.xpath("//input[@formcontrolname=\"merchantPartnerName\"]");
    final private By elem_MA_Search = By.xpath("//button[@type=\"submit\"][contains(text(),'Search')]");
    final private By elem_action_button_MA = By.xpath("//span[@class=\"action-icon table-action ng-star-inserted\"]");
    final private By elem_packageInfo_Tab= By.xpath("//a[@role=\"tab\"][contains(text(),'Package Info')]");
    final private By elem_serviceInfo_Tab= By.xpath("//a[@role=\"tab\"][@id=\"ngb-nav-6\"][contains(text(),'Service Info')]");
    final private By elem_serviceAction_button= By.xpath("//td[contains(text(),'Device Management')]/ancestor::tr//td//div//span[@title='Service Configurations']");
    final private By elem_serviceEnableDisableButton= By.xpath("//label[@for=\"customSwitch11\"]");
    final private By elem_OK_button= By.xpath("//button[contains(text(),'Ok')]");
    final private By elem_Package_button = By.xpath("//button[@type=\"button\"][contains(text(),'Add Package')]");
    final private By backdrop = By.className("backdrop");
    final private By elem_package_dropdown = By.xpath("//select[@name=\"packageListControl\"]");
    final private By elem_pricing_Dropdown = By.xpath("//select[@name=\"priceGridListControl\"]");
    final private By elem_save_package = By.xpath("//button[@type=\"button\"][contains(text(),'Save')]");
//    final private By elem_packageInfo_Tab= By.xpath("//a[@role=\"tab\"][contains(text(),'Package Info')]");
//    final private By elem_Package_button = By.xpath("//button[@type=\"button\"][contains(text(),'Add Package')]");
final private By elem_finalsave = By.xpath("//button[@type=\"button\"][contains(text(),'Save')]");

                public void navigate_to_MA()
                {
                    click(elem_by_subscription_menu);
                    click(elem_by_MA_menu);
                }

                public void search_MA(String MA_Name)
                {
                    setText(elem_MA_searchBox,MA_Name);
                    click(elem_MA_Search);
                }

                public void editMA() throws InterruptedException {
                    Thread.sleep(2000);
                    click(elem_action_button_MA);
                }


            public void goToTab() throws InterruptedException {

                    Thread.sleep(5000);
                    invisibilityForTabs(backdrop,elem_serviceInfo_Tab);
            }


            public void clickAddPackages()
            {
                click(elem_Package_button);
            }
            public void editservice() throws InterruptedException {
                Thread.sleep(3000);
            click(elem_serviceAction_button);
            }

            public void enableDisableService() throws InterruptedException {
            click(elem_serviceEnableDisableButton);
            Thread.sleep(2000);
            click(elem_OK_button);
            }

            public void selectpackage_pricing(String packageName, String PricingName) throws InterruptedException {
                dropdownSelectByValue(elem_package_dropdown,packageName);
                dropdownSelectByValue(elem_pricing_Dropdown,PricingName);

            }

            public void savePackage() throws InterruptedException
            {

                waitandClick(elem_save_package);
            }

            public void clickFinalsave() throws InterruptedException {
                scroll(elem_finalsave);
            }


            }
