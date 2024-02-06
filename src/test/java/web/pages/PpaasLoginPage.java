package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.WebDriverBase;

/**
 * POM login page
 */
public class PpaasLoginPage extends WebDriverBase {
   /* WebDriver driver;
    public PpaasLoginPage(){

        this.driver= driver;
    }*/


    /*final private By elem_userName = By.id("username");
    final private By elem_password = By.id("password");
    final private By validbutton = By.xpath("//*[@id=\"__next\"]/div/main/div[2]/div/div/form/div/div[2]/input");

    public void enterUsername(String text) {
        setText(elem_userName, text);
    }

    public void enterPassword(String text) {
        setText(elem_password, text);
    }

    public void clickValid() {
        click(validbutton);
    }*/
   final private By elem_emailid = By.id("email");
   final private By elem_continue_btn = By.xpath("//button[@class=\"login-submit-button\"]");
   final private By elem_username = By.id("username");
   final private By elem_password = By.id("password");
   final private By elem_login_btn = By.id("kc-login");

    public void enterEmailId(String text) {
        setText(elem_emailid, text);
    }
    public void clickContineuBtn() {
        click(elem_continue_btn);
    }

    public void enterUsername(String text) {
        setText(elem_username, text);
    }

    public void enterPassword(String text) {
        setText(elem_password, text);
    }

    public void clickLoginBtn() {
        click(elem_login_btn);
    }


}
