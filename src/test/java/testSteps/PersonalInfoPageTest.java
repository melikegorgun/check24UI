package testSteps;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PersonalInfoPage;
import pageObjects.CreditCardResultPage;

public class PersonalInfoPageTest {

    PersonalInfoPage personalInfoPage;

    @Parameters({"browser", "driverPath"})
    @BeforeTest
    public void passToTheResultPageWithSearchText(String browser, String driverPath) throws InterruptedException {
        CreditCardResultPage creditCardResultPage = new CreditCardResultPage(browser, driverPath);
        creditCardResultPage.openPage();
        creditCardResultPage.clickFirstButton();
        creditCardResultPage.waitForLoad();

        //pass to driver to the "Bank" page
        personalInfoPage = new PersonalInfoPage(creditCardResultPage.getDriver());


    }

    @Parameters({"email"})
    @Test(priority = 1)
    public void sendKeysToEmail(String email)
    {
        personalInfoPage.sendKeysToEmail(email);
    }


    @Test(priority = 2)
    public void contToWelcome(){
        personalInfoPage.continueToWelcome();
    }


    @Test(priority = 3)
    public void enterAsGuest() {
        personalInfoPage.waitForLoad();
        personalInfoPage.goAsGuest();
        Assert.assertEquals(personalInfoPage.formFrame.getText(),"Persönliche Angaben");
    }


    @Test(priority = 4)
    public void Should_CheckErrorMessages() throws InterruptedException {
        personalInfoPage.continueFromInfoForm();
        personalInfoPage.waitForLoad();
        System.out.println(personalInfoPage.genderMsg.getText());
        Assert.assertEquals(personalInfoPage.genderMsg.getText(),"Bitte wählen Sie Ihre Anrede aus.");
        Assert.assertEquals(personalInfoPage.surNameMsg.getText(),"Bitte geben Sie Ihren Vornamen an.");
        Assert.assertEquals(personalInfoPage.nameMsg.getText(),"Bitte geben Sie Ihren Nachnamen an.");
        Assert.assertEquals(personalInfoPage.birthDateMsg.getText(),"Bitte geben Sie Ihr Geburtsdatum an.");
        Assert.assertEquals(personalInfoPage.mobilNoMsg.getText(),"Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.");
    }
    @Parameters({"name","surName","birthDate","number"})
    @Test(priority = 5)
    public void Should_CheckNoErrorMessagesWithValidValues(String name, String surName, String birthDate, String mobilNo) {
        personalInfoPage.fillFormWithValues(name, surName, birthDate, mobilNo);
        personalInfoPage.continueFromInfoForm();
        personalInfoPage.waitForLoad();
        Assert.assertEquals(personalInfoPage.otherPersonalInfoTitle.getText(),"Weitere persönliche Angaben");
    }

    @AfterTest
    public void close() {
        personalInfoPage.getDriver().close();
    }

}
