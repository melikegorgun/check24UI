package testSteps;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CreditCardResultPage;

import java.io.IOException;


public class CreditCardResultPageTest {

    private CreditCardResultPage creditCardResultPage;


    @Parameters({"browser", "driverPath"})
    @BeforeTest
    public void openHomePage(String browser, String driverPath) {
        creditCardResultPage = new CreditCardResultPage(browser, driverPath);
        creditCardResultPage.openPage();

    }


    @Test
    public void clickContinueButton()
    {
        creditCardResultPage.clickFirstButton();
    }

    @Test
    public void Should_CheckPPSETCookie() throws IOException {
        Assert.assertEquals(creditCardResultPage.ppsetValue(),"kreditkarte");
    }

    @AfterTest
    public void close() {
        creditCardResultPage.getDriver().close();
    }

}
