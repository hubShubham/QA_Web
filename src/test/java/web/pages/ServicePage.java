package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

import java.util.Properties;

public class ServicePage extends WebDriverBase {


    final private By SERVICE_CATALOG_LABEL = By.xpath("//*[contains(text(), 'Service Catalog & Packages')]");
    final private By SERVICE_LABEL = By.xpath("//a[text()='Service']");
    final private By CREATE_BUTTON = By.xpath("//*[@type=\"button\"][contains(text(),\"Create Service\")]");
    final private By SERVICEDOMAIN = By.xpath("//select[@formcontrolname='serviceDomain']");
    final private By SERVICE_PROVIDER = By.xpath("//select[@formcontrolname='serviceProvider']");
    final private By SERVICE_NAME = By.xpath("//input[@formcontrolname='serviceName']");
    final private By LOGO = By.xpath("//input[@type='file']");
    final private By NEXT = By.xpath("//button//span[contains(text(),'Next')]");
    final private By USECASE_TAB = By.xpath("//a[text()='Use Case']");
    final private By USECASE_CHECKBOX = By.xpath("//td[text()='AES remote key injection']/preceding-sibling::td//input[@type='checkbox']");
    final private By CONFIG_TAB = By.xpath("//a[text()='Configuration']");
    final private By USAGE_TAB = By.xpath("//a[text()='Usage Events']");
    final private By ACTIVATION_TAB = By.xpath("//a[text()='Activation Parameters']");
    final private By SAVE_BUTTON = By.xpath("//button//span[text()='Save']");
    final private By BACKDROP = By.className("backdrop']");

    public void clickCatalogMenu() throws InterruptedException {
        waitforButtonAndClick(BACKDROP,SERVICE_CATALOG_LABEL);


    }
    public void clickOnServiceMenu()
    {
        click(SERVICE_LABEL);
    }

    public void clickOnCreate() throws InterruptedException {
        waitforelement(CREATE_BUTTON);
        Thread.sleep(5000);
        click(CREATE_BUTTON);
    }

public void fillBasicinfo(String name, String domain, String provider) throws InterruptedException {
    setText(SERVICE_NAME,name);
    Thread.sleep(3000);
    dropdownSelectByValue(SERVICEDOMAIN,domain);
    dropdownSelectByValue(SERVICE_PROVIDER,provider);
//    setText(LOGO,logo);
}

public void clickOnNext() throws InterruptedException {

    scrollFull(NEXT);

}

public String findAttributeTrue()
{
  String attriValue = getAttribueValue(USECASE_TAB,"aria-selected");
  return attriValue;
}

public void useCaseCheck()
{
    clickCheckBoxByText(USECASE_CHECKBOX);
}

public String findTabTrueForConfi()
{
    String attriValue = getAttribueValue(CONFIG_TAB,"aria-selected");
    return attriValue;
}

public String findTrueForUsageTab()
{

    String attriValue = getAttribueValue(USAGE_TAB,"aria-selected");
    return attriValue;
}

public String findActivationTabTrue()
{
    String attriValue = getAttribueValue(ACTIVATION_TAB,"aria-selected");
    return attriValue;

}

public void clickSubmit() throws InterruptedException {
    scrollFull(SAVE_BUTTON);
}
}