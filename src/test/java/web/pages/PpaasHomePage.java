package web.pages;


import org.openqa.selenium.By;
import web.WebDriverBase;

/**
 * POM login page
 */
public class PpaasHomePage extends WebDriverBase {

    final private By emailBox = By.xpath("//*[@id=\"__next\"]/div/main/div[2]/div/div/form/div/div[1]/input");
    final private By validbutton = By.xpath("//*[@id=\"__next\"]/div/main/div[2]/div/div/form/div/div[2]/input");

    public void enterEmail(String text) {
        setText(emailBox, text);
    }

    public void clickValid() {
        click(validbutton);
    }
}
