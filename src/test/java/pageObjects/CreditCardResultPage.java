package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.*;
import java.util.List;


public class CreditCardResultPage extends DriverInitializer {

    public CreditCardResultPage(String browser, String driverPath) {
        super.initialize(browser, driverPath);
        PageFactory.initElements(driver, this);
    }

    private final static String PAGE_URL = "https://finanzen.check24.de/accounts/d/kreditkarte/result.html";

   // @FindBy(xpath = "//span[@class='product-panel__title__counter' and text()='1.']")
    @FindBy(xpath = "//span[@class='product-panel__title__counter']/ancestor::div/child::div[@class='product-panel__controls']/child::div[@class='product-panel__controls__button']")
    public List<WebElement> continueButtons;


    @FindBy(xpath = "//a[@class='c24-cookie-consent-button' and text()='Akzeptieren']")
    public WebElement acceptCookies;


    public void openPage() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        acceptCookies.click();

    }

    public void clickFirstButton(){
        continueButtons.get(0).click();
    }

    public String ppsetValue() throws IOException {
        String ppsetValue ="";
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        URL url = new URL("https://finanzen.check24.de/accounts/d/kreditkarte/result.html");

        URLConnection connection = url.openConnection();
        connection.getContent();

        List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
        for (HttpCookie cookie : cookies) {
            if (cookie.getName().equals("ppset")){
                ppsetValue = cookie.getValue();
            }
        }
        return ppsetValue;
    }
}
