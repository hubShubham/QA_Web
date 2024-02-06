package web.pages;

import org.openqa.selenium.By;
import web.WebDriverBase;

public class issuerProgram extends WebDriverBase {

    final private By elem_by_AdvancedConfiguration = By.xpath("//span[contains(text(),'Advanced Payment Configuration')]");
    final private By elem_by_Issuer_menu = By.xpath("//a[contains(text(),'Issuer Program')]");
    final private By elem_issuer_add_button = By.xpath("//button[contains(text(),'Add Issuer Program')]");
    final private By elem_tenant_name = By.xpath("//select[@formcontrolname=\"instituteId\"]");
    final private By elem_payment_Name = By.xpath("//select[@formcontrolname=\"issuerId\"]");
    final private By elem_program_name = By.xpath("//input[@formcontrolname=\"programName\"]");
    final private By elem_program_type = By.xpath("//select[@formcontrolname=\"programType\"]");
    final private By elem_program_status = By.xpath("//select[@formcontrolname=\"programStatus\"]");
    final private By elem_Next_Button = By.xpath("//button//span[contains(text(),'Next')]");
    final private By elem_transaction_type = By.xpath("//select[@formcontrolname=\"transactionType\"]");
    final private By elem_trasnsaction_schema = By.xpath("//select[@formcontrolname=\"transactionSchema\"]");
    final private By elem_Add_mapping = By.xpath("//button[contains(text(),'Add')]");
    final private By elem_program_configuration = By.xpath("//label[contains(text(),'Expiry Date Check')]//input[@type=\"checkbox\"]/following-sibling::span");
    final private By elem_Bin_Name = By.xpath("//input[@formcontrolname=\"binName\"]");
    final private By elem_BIN_start = By.xpath("//input[@formcontrolname=\"binStart\"]");
    final private By elem_BIN_End = By.xpath("//input[@formcontrolname=\"binEnd\"]");
    final private By elem_Min_Pan = By.xpath("//input[@formcontrolname=\"panLengthMin\"]");
    final private By elem_Max_Pan = By.xpath("//input[@formcontrolname=\"panLengthMax\"]");
    final private By elem_PIN_length = By.xpath("//input[@formcontrolname=\"pinLength\"]");
    final private By elem_Add_BIN = By.xpath("//button[contains(text(),'Add')]");
    final private By elem_Save_issuer = By.xpath("//button[contains(text(),'Save')]");
    final private By backdropElement = By.className("backdrop");


    public void navigateToIssuerProgram() {
        click(elem_by_AdvancedConfiguration);
        click(elem_by_Issuer_menu);
    }

    public void addIssuer() throws InterruptedException {
        waitforButtonAndClick(backdropElement,elem_issuer_add_button);

    }

    public void fillBasicInfoOfIssuer( String paymentName, String programName, String type, String status) throws InterruptedException {
        Thread.sleep(2000);

        dropdownSelectByValue(elem_payment_Name, paymentName);
        setText(elem_program_name, programName);
        dropdownSelectByValue(elem_program_type, type);
        dropdownSelectByValue(elem_program_status, status);
    }

    public void trsanctionMapping(String type, String schema) throws InterruptedException {
        dropdownSelectByValue(elem_transaction_type,type);
        dropdownSelectByValue(elem_trasnsaction_schema, schema);

    }

    public void AddMapping()
    {
        click(elem_Add_mapping);

    }

    public void NextbuttonIssuer() {
       click(elem_Next_Button);
    }


    public void clickConfiguration() throws InterruptedException {
        Thread.sleep(2000);
        click(elem_program_configuration);
    }
public void BINdetails(String Bname, String start, String end, String Min, String Max, String PIn)
{
    setText(elem_Bin_Name, Bname);
    setText(elem_BIN_start, start);
    setText(elem_BIN_End, end);
    setText(elem_Min_Pan, Min);
    setText(elem_Max_Pan, Max);
    setText(elem_PIN_length, PIn);
    click(elem_Add_BIN);
}

public void saveIssuer() throws InterruptedException {
    scrollFull(elem_Save_issuer);
}

}