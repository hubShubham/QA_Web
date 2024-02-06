package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class DTMpage extends WebDriverBase {


    final private By elem_by_AdvancedConfiguration = By.xpath("//span[contains(text(),'Advanced Payment Configuration')]");
    final private By elem_by_DTM_menu = By.xpath("//a[contains(text(),'Dynamic Terminal Menu')]");
    final private By elem_DTM_add_button = By.xpath("//button[contains(text(),'Add Dynamic Terminal Menu')]");
    final private By elem_tenant_name = By.xpath("//select[@formcontrolname=\"instituteId\"]");
    final private By elem_payment_Name = By.xpath("//select[@formcontrolname=\"merchantPartnerId\"]");
    final private By elem_terminal_modeltype = By.xpath("//select[@formcontrolname=\"modelMasterId\"]");
    final private By elem_menu_type = By.xpath("//select[@formcontrolname=\"menuTypeId\"]");
    final private By elem_Menu_Name = By.xpath("//input[@formcontrolname=\"menuName\"]");
    final private By elem_DisplayArea = By.xpath("//select[@formcontrolname=\"displayAreaId\"]");
    final private By elem_MA_name = By.xpath("//select[@formcontrolname=\"merchantPartnerId\"]");
    final private By elem_NextButton_DTM = By.xpath("//button//span[contains(text(),'Next')]");
    final private By elem_Save_Button_DTM = By.xpath("//button[contains(text(),'Save')]");
    final private By backdrop = By.className("backdrop");
    final private By isActive_checkbox = By.xpath("//div//div//label[@for=\"active\"][contains(text(),'Is Active')]//input[@type=\"checkbox\"]");
    final private By elem_Global_Configurations = By.xpath("//span[contains(text(),'Global Configurations')]");
    final private By signature_schema = By.xpath("//a[contains(text(),'Signature Schema')]");
    final private By elem_action_button_signature = By.xpath("//td//span");
    final private By serviceDomain_Dropdown = By.xpath("//select[@formcontrolname=\"programId\"]");
    final private By serviceDomain_Configuration = By.xpath("//select[@formcontrolname=\"serviceDomainConfigurationId\"]");
    final private By domain_usecase = By.xpath("//label[text()='Service Domain Use Case ']/following-sibling::select");
    final private By serviceName = By.xpath("//label[text()='Service ']/following-sibling::select");




    public void  navigateToDTM()
    {
        click(elem_by_AdvancedConfiguration);
        click(elem_by_DTM_menu);
    }

    public void addbuttonDTM() throws InterruptedException {
        invisibilityForTabs(backdrop,elem_DTM_add_button);
    }

    public void  detailsPage(String tenantName, String MAname, String modeltype, String menuType, String menuname, String displayArea) throws InterruptedException {
        dropdownSelectByValue(elem_tenant_name,tenantName);
        dropdownSelectByValue(elem_MA_name, MAname);
        dropdownSelectByValue(elem_terminal_modeltype, modeltype);
        dropdownSelectByValue(elem_menu_type,  menuType);
        setText(elem_Menu_Name, menuname);
        dropdownSelectByValue(elem_DisplayArea, displayArea);
        clickCheckBoxByText(isActive_checkbox);

    }

    public void clickonNext()
    {
        click(elem_NextButton_DTM);

    }
    public void saveDTM()
    {
        click(elem_Save_Button_DTM);
    }

    public void signatureFiledownload() throws InterruptedException {
        invisibilityForTabs(backdrop,elem_Global_Configurations);
        click(signature_schema);
        click(elem_action_button_signature);
    }



    public void  detailspageProgramSpecific( String MAname, String modeltype, String menuType, String menuname, String displayArea, String serviceDomain,String service, String domaionUseCase, String config) throws InterruptedException {

        dropdownSelectByValue(elem_MA_name, MAname);
        dropdownSelectByValue(elem_terminal_modeltype, modeltype);
        dropdownSelectByValue(elem_menu_type,  menuType);
        setText(elem_Menu_Name, menuname);
        dropdownSelectByValue(elem_DisplayArea, displayArea);
        clickCheckBoxByText(isActive_checkbox);
        dropdownSelectByValue(serviceDomain_Dropdown,serviceDomain);
        dropdownSelectByValue(serviceName,service);
        dropdownSelectByValue(domain_usecase,domaionUseCase);

        dropdownSelectByValue(serviceDomain_Configuration,config);

    }


}
