package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class Pricing extends WebDriverBase {


    final private By elem_by_pricing_catalog_menu = By.xpath("//*[contains(text(), 'Service Catalog & Packages')]");
    final private By elem_by_pricing_menu = By.xpath("//a[contains(text(), 'Pricing Grid')]");
    final private By elem_pricing_add_btn = By.xpath("//button[contains(text(),'Add Pricing')]");
    final private By elem_tenant_name = By.xpath("//*[@id=\"tenantId\"]");
    final private By elem_pricing_name = By.xpath("//input[@type=\"text\"][@formcontrolname=\"name\"]");
    final private By elem_type_Of_Pricing = By.xpath("//select[@formcontrolname=\"type\"]");
    final private By elem_packages_dropdown = By.xpath("//select[@formcontrolname=\"packages\"]");
    final private By elem_date = By.xpath("//input[@type=\"date\"]");
    final private By Next_Button = By.xpath("//button[contains(text(),'Next')]");
    final private By setupFee_dropdown = By.xpath("//select[@formcontrolname=\"setupFeeInr\"]");
    final private By setupFee_text = By.xpath("//input[@formcontrolname=\"setupFee\"]");
    final private By subsFee_dropdown = By.xpath("//select[@formcontrolname=\"subscriptionFeeInr\"]");
    final private By subsFee_text = By.xpath("//input[@formcontrolname=\"subscriptionFee\"]");
    final private By finalSave_button = By.xpath("//button[contains(text(),'Save')]");



    public void naviagteToPricingGrid()
    {
        click(elem_by_pricing_catalog_menu);
        click(elem_by_pricing_menu);
    }


    public void clickOnAddPricing()
    {
        click(elem_pricing_add_btn);
    }

    public void basicInfofieldsPriing(String tenantname,String Pricingname,String type, String packages, String date) throws InterruptedException {
        dropdownSelectByValue(elem_tenant_name,tenantname);
        setText(elem_pricing_name,Pricingname);
        dropdownSelectByValue(elem_type_Of_Pricing,type);
        dropdownSelectByValue(elem_packages_dropdown,packages);
        Thread.sleep(3000);
        setText(elem_date,date);
    }

    public void clickOnNext()
    {
      click(Next_Button);
    }


    public void packagePricingTab(String setUp,String setupValue, String subsFee, String subsValue) throws InterruptedException {
        dropdownSelectByValue(setupFee_dropdown,setUp);
        setText(setupFee_text,setupValue);
        dropdownSelectByValue(subsFee_dropdown,subsFee);
        setText(subsFee_text,subsValue);
    }

    public void finalSavePricing()
    {
        click(finalSave_button);
    }

}
