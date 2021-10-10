package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInpage extends BaseClass {

    public SignInpage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='signin-loginid']")
    public WebElement emailTextBox;


    @FindBy(xpath = "//input[@id='signin-password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@id='submitButton']")
    public WebElement loginSubmitButton;

    @FindBy(xpath = "//div[@id='gc-custom-header-nav-bar-acct-menu']/button/div")
    public WebElement userNameLink;


public void enterLoginInfo(){

    sendKeysToInput(emailTextBox, "h.n222@yahoo.com");
    sendKeysToInput(passwordTextBox, "Salma123#");
    clickOnElement(loginSubmitButton);

}

public String getFirstNameOfUser(){
    waitForElementToBeVisible(userNameLink);
    return userNameLink.getText().toString();

}

    public boolean isUsernameCorrect(){
        return getFirstNameOfUser().contains("Mst");

    }















}
