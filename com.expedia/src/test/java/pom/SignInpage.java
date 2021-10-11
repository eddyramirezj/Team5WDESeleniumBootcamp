package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pnt1001Utils.DbManager;
import pnt1001Utils.ExcelReader;

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
    ExcelReader excel = new ExcelReader(expediaExcelPath);


public void enterLoginInfo3() {

    for (int i=1; i<=3; i++) {
        sendKeysToInput(emailTextBox, DbManager.getEmail("team5bootcamp.expedialogin", 100+i));
        sendKeysToInput(passwordTextBox, DbManager.getPassword("team5bootcamp.expedialogin", 100+i));
    }


        clickOnElement(loginSubmitButton);


}

    public void enterLoginInfo2() {

        sendKeysToInput(emailTextBox, DbManager.getEmail("team5bootcamp.expedialogin", 101));
        sendKeysToInput(passwordTextBox, DbManager.getPassword("team5bootcamp.expedialogin", 101));
//    clickOnElement(loginSubmitButton);


    }

    public void enterLoginInfo() {


        int rows = excel.getRowCount("testLogin");
        for (int i = 1; i <= rows; i++) {



            sendKeysToInput(emailTextBox, excel.getCellData("testLogin", 2, i + 1));
            sendKeysToInput(passwordTextBox, excel.getCellData("testLogin", 3, i+1));
//    clickOnElement(loginSubmitButton);

        }
    }


public String getFirstNameOfUser(){
    waitForElementToBeVisible(userNameLink);
    return userNameLink.getText().toString();

}

    public boolean isUsernameCorrect(){
        return getFirstNameOfUser().contains("Mst");

    }















}
