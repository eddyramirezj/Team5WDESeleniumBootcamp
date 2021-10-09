package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends BaseClass {

    public Register() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="button#registerNowBtn")
    public WebElement registerBtn;

    @FindBy (css="input[name='firstName']")
    public WebElement inputFirstName;

    @FindBy (css="input[name='lastName']")
    public WebElement inputLastName;

    @FindBy (css="input[name='emailAddress']")
    public WebElement inputEmail;

    @FindBy (css="input[name='newPassword']")
    public WebElement inputPassword;

    @FindBy (css="input[name='confirmPassword']")
    public WebElement inputConfirmPassword;

    @FindBy (css="div.mat-checkbox-inner-container")
    public WebElement termsAndConditionsCheckbox;

    @FindBy (css="button#registerBtn")
    public WebElement registerNowBtn;

    @FindBy (css="button#registerBtn[disabled]")
    public WebElement registerNowBtnDisabled;

    @FindBy (css="//h1[text()=' Thank You for Registering ']")
    public WebElement registrationConfirmationMsg;

    public Register clickOnRegisterAccount() {
        waitForElementToBeClickable(registerBtn);
        clickOnElement(registerBtn);
        waitForElementToBeVisible(inputFirstName);
        return new Register();
    }

    public Register sendKeysToFirstNameField(String value) {
        waitForElementToBeVisible(inputFirstName);
        sendKeysToInput(inputFirstName, value);
        waitForElementToBeVisible(inputLastName);
        return new Register();
    }

    public Register sendKeysToLastNameField(String value) {
        waitForElementToBeVisible(inputLastName);
        sendKeysToInput(inputLastName, value);
        waitForElementToBeVisible(inputEmail);
        return new Register();
    }

    public Register sendKeysToEmailField(String value) {
        waitForElementToBeVisible(inputEmail);
        sendKeysToInput(inputEmail, value);
        waitForElementToBeVisible(inputPassword);
        return new Register();
    }

    public Register sendKeysToPasswordField(String value) {
        waitForElementToBeVisible(inputPassword);
        sendKeysToInput(inputPassword, value);
        waitForElementToBeVisible(inputConfirmPassword);
        return new Register();
    }

    public Register sendKeysToConfirmPasswordField(String value) {
        waitForElementToBeVisible(inputConfirmPassword);
        sendKeysToInput(inputConfirmPassword, value);
        waitForElementToBeVisible(termsAndConditionsCheckbox);
        return new Register();
    }

    public Register clickOnTermsAndConditionsCheckbox() {
        waitForElementToBeClickable(termsAndConditionsCheckbox);
        clickOnElement(termsAndConditionsCheckbox);
        waitForElementToBeClickable(registerNowBtn);
        return new Register();
    }

    public void clickOnRegisterNowBtn() {
        waitForElementToBeClickable(registerNowBtn);
        clickOnElement(registerNowBtn);
        waitForElementToBeVisible(registrationConfirmationMsg);

    }

}
