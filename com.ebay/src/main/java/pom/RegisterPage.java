package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {


    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="input#firstname")
    public WebElement firstnameInputField;

    @FindBy (css="input#lastname")
    public WebElement lastnameInputField;

    @FindBy (css="input#Email")
    public WebElement emailInputField;

    @FindBy (css="input#password")
    public WebElement passwordInputField;

    @FindBy (css="input.checkbox__control")
    public WebElement showPasswordCheckBox;

    @FindBy (css="button#EMAIL_REG_FORM_SUBMIT")
    public WebElement createAccountButton;

    @FindBy (css="div.password-comp span.error-message")
    public WebElement invalidPasswordErrorMessage;

    @FindBy (css="input[class='radio__control '][value='businessaccount']")
    public WebElement businessAccountRadioButton;

    @FindBy (css="input#businessName")
    public WebElement businessNameInputField;

    @FindBy (css="input#businessEmail")
    public WebElement businessEmailInputField;

    @FindBy (css="bizPassword")
    public WebElement businessAccountPasswordInputField;

    @FindBy (css="BUSINESS_REG_FORM_SUBMIT")
    public WebElement createBusinessAccountButton;

    @FindBy (css="span#bizPassword_err")
    public WebElement invalidBusinessPasswordErrorMessage;

    @FindBy (css="button#gh-ug")
    public WebElement greetingsMenu;

    public void registerAnAccount(String firstname, String lastname, String email, String password) {
        fluentWaitForElementToBeClickable(firstnameInputField);
        sendKeysToInput(firstnameInputField, firstname);
        fluentWaitForElementToBeClickable(lastnameInputField);
        sendKeysToInput(lastnameInputField, lastname);
        fluentWaitForElementToBeClickable(emailInputField);
        sendKeysToInput(emailInputField, email);
        fluentWaitForElementToBeClickable(passwordInputField);
        sendKeysToInput(passwordInputField, password);
        fluentWaitForElementToBeClickable(showPasswordCheckBox);
        clickOnElement(showPasswordCheckBox);
        fluentWaitForElementToBeClickable(createAccountButton);
        clickOnElement(createAccountButton);

    }

    public void registerBusinessAccount(String businessName, String businessEmail, String businessAccountPassword) {
        fluentWaitForElementToBeVisible(businessAccountRadioButton);
        businessAccountRadioButton.click();
        fluentWaitForElementToBeClickable(businessNameInputField);
        sendKeysToInput(businessNameInputField, businessName);
        fluentWaitForElementToBeClickable(businessEmailInputField);
        sendKeysToInput(businessEmailInputField, businessEmail);
        fluentWaitForElementToBeClickable(businessAccountPasswordInputField);
        sendKeysToInput(businessAccountPasswordInputField, businessAccountPassword);
        fluentWaitForElementToBeClickable(createBusinessAccountButton);
        clickOnElement(createBusinessAccountButton);
    }

}
