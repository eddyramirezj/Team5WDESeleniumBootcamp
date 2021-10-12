package testBoaPom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BoaHomePage extends BaseClass {

    public BoaHomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@placeholder='Online ID']")
    public WebElement onlineIdTextBox;

    @FindBy(xpath = "//input[@placeholder='Passcode']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@id='signIn']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='error-message']/li")
    public WebElement errorMessage;




    public void testLogin(String onlineId, String password){

        sendKeysToInput(onlineIdTextBox,onlineId);
        sendKeysToInput(passwordTextBox,password);
        clickOnElement(signInButton);
        Boolean contains = errorMessage.getText().toString().contains("does not match");
        verifyTrue(contains);

    }




}
