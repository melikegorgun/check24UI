package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PersonalInfoPage extends DriverInitializer {

    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@type='email' and @data-tid='input-login']")
    public WebElement emailTextBar;

    @FindBy(xpath = "//div[@class='c24-uli-cl-box-option style-scope unified-login' and text()='Ich möchte als Gast fortfahren']")
    public WebElement continueChoice;

    @FindBy(xpath = "//button[@type='submit' and @id='c24-uli-register-btn']")
    public WebElement wellComeFrameContinueButton;

    @FindBy(xpath = "//section//h2[@class='styles__SectionTitle-oer35e-1 bTwFvn']")
    public WebElement formFrame;

    @FindBy(xpath = "//div[@class='styles__ButtonWrapper-sc-1solng-1 dwSWhP']")
    public WebElement formFrameContinueButton;

    @FindBy(xpath = "//div[@type='ERROR']//label[text()='Bitte wählen Sie Ihre Anrede aus.']")
    public WebElement genderMsg;

    @FindBy(xpath = "//div[@type='ERROR']//label[text()='Bitte geben Sie Ihren Vornamen an.']")
    public WebElement surNameMsg;

    @FindBy(xpath = "//div[@type='ERROR']//label[text()='Bitte geben Sie Ihren Nachnamen an.']")
    public WebElement nameMsg;

    @FindBy(xpath = "//div[@type='ERROR']//label[text()='Bitte geben Sie Ihr Geburtsdatum an.']")
    public WebElement birthDateMsg;

    @FindBy(xpath = "//div[@type='ERROR']//label[text()='Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.']")
    public WebElement mobilNoMsg;


    @FindBy(xpath = "//label[@for='GENDER_FEMALE']")
    public WebElement genderFemale;

    @FindBy(xpath = "//input[@id='GIVEN_NAME']")
    public WebElement surNameBar;

    @FindBy(xpath = "//input[@id='LAST_NAME']")
    public WebElement nameBar;

    @FindBy(xpath = "//input[@id='DATE_OF_BIRTH']")
    public WebElement birthDateBar;

    @FindBy(xpath = "//input[@id='PHONENUMBER_MOBILE']")
    public WebElement mobilNoBar;

    @FindBy(xpath = "//h2[text()='Weitere persönliche Angaben']")
    public WebElement otherPersonalInfoTitle;


    public void sendKeysToEmail(String email){

        emailTextBar.sendKeys(email);
    }

    public void continueToWelcome(){
        emailTextBar.sendKeys(Keys.ENTER);
    }

    public void goAsGuest(){
       continueChoice.click();
       wellComeFrameContinueButton.click();
       //Here is not working on Chrome,it is impossible to click these two elements on any chrome version,it gives below error;
        // "org.openqa.selenium.javascriptexception: javascript error: d.elementfrompoint is not a function"
        //I was doubtful if the elements are hidden and try to click hidden elements
        //I was doubtful if the element locator brings more than one webelement and I chanced my locator syntax in many different ones
        //Then I found a comment that says it is a Chrome mistake, I can not be sure, please assume that as a known issue
        //NoSuchElementException in the report consists because of that reason
    }

    public void continueFromInfoForm()
    {
        formFrameContinueButton.click();
    }

    public void fillFormWithValues(String surName, String name, String birthDate, String mobilNo)
    {
        genderFemale.click();
        surNameBar.sendKeys(surName);
        nameBar.sendKeys(name);
        birthDateBar.sendKeys(birthDate);
        mobilNoBar.sendKeys(mobilNo);

    }
}
