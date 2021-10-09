package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends BaseClass {

    public Register() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="input[name='emailAddress']")
    public WebElement loginInputEmail;

    @FindBy (css="input[name='password']")
    public WebElement loginInputPassword;

    @FindBy (css="button#loginBtn")
    public WebElement loginBtn;

    @FindBy (css="button#loginBtn[disabled]")
    public WebElement loginBtnDisabled;

    @FindBy (xpath="//p[contains(text(), ' The information you entered does not match our records')]")
    public WebElement infoNotMatchWarning;

    @FindBy (css="a#accountsBtn")
    public WebElement myAccountTabBtn;

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

    @FindBy (xpath="//h1[text()=' Thank You for Registering ']")
    public WebElement registrationConfirmationMsg;

    @FindBy (xpath="//p[contains(text(), 'This email address has already been registered')]")
    public WebElement emailAlreadyRegisteredWarning;

    @FindBy (css="button#forgotPasswordBtn")
    public WebElement forgotPasswordLink;

    @FindBy (css="input#forgotPasswordEmailAddressInput")
    public WebElement forgotPasswordEmail;

    @FindBy (css="button#resetPasswordBtn")
    public WebElement forgotPasswordContinueBtn;

    @FindBy (xpath="//p[contains(text(), 'We have sent you an email with a link to reset your password')]")
    public WebElement forgotPasswordConfirmationEmailMsg;

    @FindBy (css="a[title='Contact Us']")
    public WebElement contactUsLink;

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

    public Register sendKeysToEmailLoginField(String value) {
        waitForElementToBeVisible(loginInputEmail);
        sendKeysToInput(loginInputEmail, value);
        waitForElementToBeVisible(loginInputPassword);
        return new Register();
    }

    public Register sendKeysToPasswordLoginField(String value) {
        waitForElementToBeVisible(loginInputPassword);
        sendKeysToInput(loginInputPassword, value);
        waitForElementToBeVisible(loginBtn);
        return new Register();
    }

    public void clickOnLoginBtn() {
        waitForElementToBeClickable(loginBtn);
        clickOnElement(loginBtn);
        waitForElementToBeVisible(myAccountTabBtn);

    }

    public void forgotPasswordFromLogin(String value) {
        waitForElementToBeClickable(forgotPasswordLink);
        clickOnElement(forgotPasswordLink);
        waitForElementToBeVisible(forgotPasswordEmail);
        sendKeysToInput(forgotPasswordEmail, value);
        waitForElementToBeClickable(forgotPasswordContinueBtn);
        clickOnElement(forgotPasswordContinueBtn);
        waitForElementToBeVisible(forgotPasswordConfirmationEmailMsg);

    }

    public ContactUs navigateToContactUs() {
        waitForElementToBeClickable(contactUsLink);
        scrollJS(1000);
        clickJScript(contactUsLink);
        return new ContactUs();
    }

}
