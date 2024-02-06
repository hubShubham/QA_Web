package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepdefinitions.CommonStepDef;
import web.WebDriverBase;

public class PackagePage extends WebDriverBase {


    final private By elem_by_package_catalog_menu = By.xpath("//*[contains(text(), 'Service Catalog & Packages')]");
    final private By elem_by_package_menu = By.xpath("//a[contains(text(), 'Packages')]");
    final private By elem_package_add_btn = By.xpath("//*[@type=\"button\"][contains(text(),\"Add Packages\")]");
    final private By elem_tenant_name = By.xpath("//*[@id=\"tenantId\"]");
    final private By elem_package_code = By.xpath("//input[@id='packageCode']");
    final private By elem_package_name = By.xpath("//input[@id='name']");
    final private By elem_publish_date = By.xpath("//*[@id=\"publishDate\"]");
    final private By elem_next_btn = By.xpath("//*[@id=\"content\"]/app-add-packages/div[3]/div/button");
    final private By elem_click_region = By.xpath("//*[@id=\"regionId\"]");
    final private By elem_select_region = By.xpath("//ng-multiselect-dropdown[@formcontrolname=\"regionId\"]//div[@class=\"multiselect-dropdown\"]//div[@class=\"dropdown-list\"]//ul[@class=\"item2\"]");
    final private By elem_click_country = By.xpath("//*[@id=\"countryId\"]");
    final private By elem_select_country = By.xpath("//ng-multiselect-dropdown[@formcontrolname=\"countryId\"]//div[@class=\"multiselect-dropdown\"]//div[@class=\"dropdown-list\"]//ul[@class=\"item2\"]//*[contains(text(), 'France')]");
    final private By backdrop = By.className("backdrop");
    final private By serviceCheckBox_APM = By.xpath("//label[@class='custom-checkbox checkbox-sm' ] [contains(text(),'APM Acceptance Service')]//input[@id='isServiceActive']");
    final private By serviceOption = By.xpath("//*[@id=\"sb\"]/div/div/div[4]/div[2]/div/select");
    final private By saveButton = By.xpath("//button[@type='submit']");
    final private By searchByPackageName = By.xpath("//input[@name='packageName']");
    final private By searchButton = By.xpath("//button[@type='submit'][contains(.,'Search')]");
    final private By actionbuttopn = By.xpath("//span[@class=\"action-icon table-action ng-star-inserted\"]");
    final private By CheckText_elem = By.xpath("//label[contains(text(),'')]" );
    final private By checkBox_input_elem = By.xpath("//label[contains(text(),'APM Acceptance Service')]//input");
    final private By elem_isActive_package = By.xpath("//input[@type=\"checkbox\"][@formcontrolname=\"isActive\"]");
//new xpaths--
final private By Part_code_pro = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapCodeProfessionalFee\"]");
    final private By sapDescription_Pro = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapDescriptionProfessionalFee\"]");
    final private By sapCodeFee_Subs = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapCodeSubscriptionFee\"]");
    final private By sapDescription_Subs = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapDescriptionSubscriptionFee\"]" );
    final private By sapCode_Usage = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapCodeUsageFee\"]");
    final private By sapDescription_Usage = By.xpath("//input[@type=\"text\"][@formcontrolname=\"sapDescriptionUsageFee\"]");
    final private By elem_ServiceDomain_dropdown = By.xpath("//select[@id=\"tenantServiceDomainId\"]");
    final private By elem_Service_dropdown = By.xpath("//select[@id=\"tenantServiceId\"]");
    final private By elem_AddtoPackages_biutton = By.xpath("//button[contains(text(),'Add to Package')]");

    public void sapInfotab(String code_pro,String desc_pro,String code_subs, String desc_subs, String code_usage, String desc_usage) {
        setText(Part_code_pro, code_pro);

        setText(sapCodeFee_Subs, code_subs);

        setText(sapCode_Usage, code_usage);

    }

public void listOfServices(String domainName, String serviceName) throws InterruptedException {
    dropdownSelectByValue(elem_ServiceDomain_dropdown,domainName);
    dropdownSelectByValue(elem_Service_dropdown,serviceName);
}

public void AddtopackageButton()
{
    click(elem_AddtoPackages_biutton);
}

    public void searchbyPackageName(String packageName)
    {
        setText(searchByPackageName,packageName);

    }
    public void chooseAndClick(String serviceName)
    {

        selectCheckBoxesasPerChoice(serviceName,CheckText_elem,checkBox_input_elem);
    }
    public void clickOnsearchButton()
    {
        click(searchButton);
        waitForPageLoad();
    }
    public void clickOnActionButton() throws InterruptedException {
        Thread.sleep(3000);
        click(actionbuttopn);
    }

    public void clickCheckBox()
    {
        waitForPageLoad();
       clickCheckBoxByText(serviceCheckBox_APM);
    }

   public void serviceSelection(String OptionName) throws InterruptedException {
            dropdownSelectByValue(serviceOption,OptionName);
    }


    public void clickAddButton_package() {
        click(elem_package_add_btn);
        waitForPageLoad();


    }
    public void navigateToPackagePage() {
        click(elem_by_package_catalog_menu);
        click(elem_by_package_menu);

    }


    public void addPackage( String packageCode,String packageName , String publishDate,String region, String country ) throws InterruptedException {
        //  click(elem_tenant_name);

        setText(elem_package_name, packageName);
        setText(elem_package_code, packageCode);
        setText(elem_publish_date, publishDate);
        dropdownSelectByValue(elem_click_region, region);
        dropdownSelectByValue(elem_click_country, country);


    }

    public void clickNextButtonforPackage()
    {
        click(elem_next_btn);
        waitForPageLoad();
    }
    public void clickSaveButton()
    {
        clickCheckBoxByText(saveButton);

    }
    public void clicksaveWhileediting() throws InterruptedException {
        scroll(saveButton);
        Thread.sleep(3000);

    }

    public void activeInactive() throws InterruptedException {

        scroll(elem_isActive_package);
    }



}