package web;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebpageFactory {

  private WebDriverBase webDriverBase = null;

    public WebpageFactory(WebDriverBase webDriverBase) {
               this.webDriverBase = webDriverBase;
    }

    public void open_page(String url) {
        var driver = webDriverBase.getDriver();
        assertThat(driver).isNotNull();
        System.out.println("The URL is " + url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

}
