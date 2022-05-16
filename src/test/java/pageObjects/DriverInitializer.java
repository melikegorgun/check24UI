package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverInitializer {

    private final static String CHROME_BROWSER = "chrome";
    private final static String FIREFOX_BROWSER = "firefox";

    protected WebDriver driver;

    public void initialize(String browser, String driverPath) {

        if (browser == null) {
            browser = DriverInitializer.CHROME_BROWSER;
        }

        if (driverPath == null) {
            throw new RuntimeException("Driver is empty.");
        }

        switch (browser) {
            case DriverInitializer.CHROME_BROWSER:
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                break;
            case DriverInitializer.FIREFOX_BROWSER:
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }


    public WebDriver getDriver() {
        return driver;
    }


    public void waitForLoad()
    {
        JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page has loaded");
        }
        //iterate 50 times after every one second to verify if in ready state
        for (int i=0; i<50; i++){
            try {
                Thread.sleep(3000);
            }catch (InterruptedException ex) {
                System.out.println("Page has not loaded yet ");
            }
            //again check page state
            if (j.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }

}

