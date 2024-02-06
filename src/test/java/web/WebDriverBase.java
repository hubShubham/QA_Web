package web;


import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import utils.PropertiesUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;


public class WebDriverBase  {

   //public static final Logger logger = Logger.getLogger(WebDriverBase.class);
    protected static WebDriver driver = null;
    static Properties properties = PropertiesUtils.loadProperties();
    protected final int timeouts = 5;
    protected JavascriptExecutor js;
    protected WebDriverWait waiter;

    public WebDriverBase() {
        if (driver != null) {
            waiter = (WebDriverWait) new WebDriverWait(driver, timeouts)
                    .pollingEvery(Duration.ofMillis(5000))
                    .ignoring(StaleElementReferenceException.class);
            js = (JavascriptExecutor) driver;


        }
        getDriver();
    }

   /**
     * Close Driver: delete all cookies for new session, tearDownClass() will handle closing the driver
     */
    protected static void clearCookies() {
        if (null != driver) {
            driver.manage().deleteAllCookies();
        }
    }

   /**
     * Quit Driver: tearDownClass() will handle closing the driver
     */
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

   /**
     * Get the driver with devices for OS
     */
   public WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        var driverName = properties.getProperty("webdriver");
        WebDriverManager wedm= new ChromeDriverManager();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(ChromeOptions.CAPABILITY, options);
        var os = System.getProperty("os.name");
        ClassLoader classLoader = getClass().getClassLoader();
      //  logger.info("OS platform " + os);
        if (os.toLowerCase().contains("linux")) {
            System.out.println("Starting test on chrome");
//            String path = classLoader.getResource("../webdriver/linux/" + driverName).getPath();
//            System.setProperty("webdriver.chrome.driver", path);

            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
//            //options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            //options.addArguments("--no-sandbox"); // Bypass OS security model
            options.setHeadless(true);
            wedm.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (os.toLowerCase().contains("window")) {
            wedm.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }
/*
    public WebDriver getDriver(){
        if (driver != null) {
            return driver;
        }
        String browserName=properties.getProperty("webdriver");
        if(browserName.contains("chromedriver")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            DesiredCapabilities c = DesiredCapabilities.chrome();
            c.setCapability(ChromeOptions.CAPABILITY, options);

        }else if(browserName.contains("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            DesiredCapabilities c = DesiredCapabilities.chrome();
            c.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options);
        }
        return driver;
    }*/

    /**
     * Get Site Url from pom.xml properties or command line -DsiteUrl
     */
    public String getSiteBaseUrl() {
        return System.getProperty("siteUrl");
    }

    /*
     * Select element describe by locator
     *
     * @param locator
     * @return WebElement
     */
    protected WebElement select(By locator) {
        try {
            return waiter
                    .withMessage(String.format("Could not found element with locator %s", locator))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ex) {
           System.out.println(ex);
        }
        return null;
    }

    /**
     * click on element describe by locator
     *
     * @param locator
//     */
    protected void click(By locator) {

        select(locator).click();
    }
    protected String getText(By locator) {
        return select(locator).getText();
    }


    protected void setText(By locator, String input) {
         select(locator).clear();
        select(locator).sendKeys(input);
    }

    protected void  waitElementToBeSelected(By locator){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(select(locator)));
    }

    protected void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void waitforButtonAndClick(By elementToWwaitFor,By elementToClick) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,3);
        boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(elementToWwaitFor));
        if(invisible)
        {
            click(elementToClick);
        }
    }
    public void invisibility(By locatorInvisible,By locatorVisible,String text) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,3);
        boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorInvisible));
        if(invisible)
        {
           dropdownSelectByValue(locatorVisible,text);
        }
    }
    public void invisibilityForTabs(By locatorInvisible,By locatorVisible) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,3);
        boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorInvisible));
        if(invisible)
        {
           click(locatorVisible);
        }
    }
    public void scroll(By locator) throws InterruptedException {
      Actions a=new Actions(driver);
      a.sendKeys(Keys.PAGE_DOWN).build().perform();
      Thread.sleep(2000);
      WebElement elem= driver.findElement(locator);
      elem.click();
    }
    public void scrollFull(By locator) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", select(locator));
        Thread.sleep(3000);
        click(locator);

    }


    public void selectCheckBoxesasPerChoice(String name,By locator1,By locator2)
    {
        List<WebElement> element1 = driver.findElements(locator1);
        List<WebElement> element2 = driver.findElements(locator2);
        for(WebElement elem : element1) {
            String s = elem.getText();
            if (elem.getText().equals(name)) {
                for (WebElement elem2 : element2) {
                    elem2.click();
                }
            }
        }


    }

    public String  getAttribueValue(By locator, String attribute)
    {
        String value=select(locator).getAttribute(attribute);
        return value;
    }
   public void clickCheckBoxByText( By locatorCheckbox) {
      WebElement checkbox= driver.findElement(locatorCheckbox);
       if (!checkbox.isSelected()) {
           checkbox.click();
       }
     else   if (checkbox.isSelected()) {
           System.out.println("Checkbox is checked");
           // Perform actions when checkbox is checked
       } else {
           System.out.println("Checkbox is not checked");
           // Perform actions when checkbox is not checked
       }
   }
   public void waitandClick(By  locator)
   {
    WebDriverWait wait=new WebDriverWait(driver,5);
    WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    e.click();

   }


    public static void captureScreenshot(WebDriver driver, String filePath) {
        // Convert WebDriver instance to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        try {
            // Capture screenshot as a file
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Copy the file to the specified path
            File destinationFile = new File(filePath);
            org.apache.commons.io.FileUtils.copyFile(sourceFile, destinationFile);

            System.out.println("Screenshot captured and saved at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error while capturing screenshot: " + e.getMessage());
        }
    }



    public void waitforelement(By locator)
   {
       waiter=new WebDriverWait(driver, 7000);
       waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }

    protected void dropdownSelectByValue(By locator, String text)  {
      try
      {
          click(locator);
          waiter=new WebDriverWait(driver, 2000);
          waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
          Select location = new Select(select(locator));
          location.selectByVisibleText(text);

      }
      catch(Exception e)
        {
          e.getCause();
        }
    }

    protected  void dynamicDropdown(By locator, String text,By locatorCB){
        click(locator);
        setText(locator,text);
        click(locatorCB);

    }

 protected  void dd(By locator, By enterText , String text, By selectLocation){
     click(locator);
     setText(enterText, text);
     click(selectLocation);

    }
    protected void handleDynamicDropdown(By locator, String text, By locators) throws InterruptedException {
        click(locator);
        int count =0;
        List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators));
        for (WebElement element:myList) {

              if (element.getText().contains(text) ) ;
                {
                System.out.println("The list of drop element is "+  element.getText());
                System.out.println(" element is "+  element);
                 element.click();
                count ++;
                }
        }
            if(count!=0){
             System.out.println( text + "has been selected in dd");
            }
            else {
            System.out.println( "text is not available in dropdown");
            }
    }

    public void verifyText(String expectedText, String actualText){
        Assert.assertEquals(expectedText,actualText);
    }
}
