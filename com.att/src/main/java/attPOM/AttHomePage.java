package attPOM;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilsPNT1001.AlertHelper;
import utilsPNT1001.ComboBoxHelper;
import utilsPNT1001.WindowHelper;

public class AttHomePage extends BaseClass {

    public AttHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "z1-searchfield")
    public WebElement searchField;

    @FindBy(xpath = "//div[@id='Tab-tab-2']/descendant::div[@class='_2syZ7'][contains(text(),'Showing 1-')]")
    public WebElement searchResultText;

    @FindBy(xpath = "//div[@id='z1-tier1Nav']//span[text()='Internet']")
    public WebElement internetMenu;

    @FindBy(xpath ="//div[@id='HERO_PANEL22']//a[@aria-label='Check availability']")
    public WebElement checkAvailabilityButton;

    @FindBy(xpath ="//i[@title='Edit your address']")
    public WebElement editAddressLink;

    @FindBy(xpath ="//div[@class='_tM_9A']/input")
    public WebElement addressInputField;

    @FindBy(xpath ="//div[@class='type-base']")
    public WebElement addressChecked;

    @FindBy(partialLinkText ="Prepaid")
    public WebElement prepaidLink;

    @FindBy(partialLinkText ="Get started")
    public WebElement getStarted;

    @FindBy(xpath ="//button[@data-test-id='WRLS_PlanCard_PROD10080345_Button_PlanDetail']")
    public WebElement selectBestValuePlanBtn;



    @FindBy(xpath ="(//span[contains(@data-test-id,'Label_TitlePrice')])[2]")
    public WebElement selectedPlanText;

    @FindBy(partialLinkText ="Wireless")
    public WebElement wirelessLink;

    @FindBy(xpath ="(//div[@class='_1HEKn undefined'])[2]")
    public WebElement iPhone13;

    @FindBy(xpath ="//div[@class='jsx-3404677130']//input[@id='Product(Red)']")
    public WebElement mobileColor;

    @FindBy(xpath ="//button[contains(text(),'Continue')]")
    public WebElement continueToCartButton;

    @FindBy(xpath ="//h1[@id='intentModalHeader']")
    public WebElement dialogBoxText;

    @FindBy(xpath ="//span[@id='z1-profile-text']")
    public WebElement accountLink;

    @FindBy(partialLinkText ="Sign in")
    public WebElement signInLink;

    @FindBy(xpath ="//input[@id='userID']")
    public WebElement userIdField;

    @FindBy(xpath ="//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath ="//button[@id='signin']")
    public WebElement signInButton;

    @FindBy(xpath ="//div[@id='errorDescArea']")
    public WebElement signInErrorMsg1;

    @FindBy(xpath ="//div[@class='bad-request-div']/h1")
    public WebElement signInErrorMsg2;




public String cellPhoneSearch(String searchText){
    sendKeysToInput(searchField,searchText);
    pressEnter(searchField);
    String result = searchResultText.getText();
    System.out.println(result);
    return result;
}

    public void checkInternetService(String inputAddress){

    clickJScript(internetMenu);
    clickJScript(checkAvailabilityButton);
//    clickOnElement(editAddressLink);
//        WindowHelper.switchTo(1);
//        AlertHelper.sendKeys(inputAddress);
    sendKeysToInput(addressInputField,inputAddress);
    pressEnter(addressInputField);
    }

    public void prepaidOffer(){
        clickOnElement(prepaidLink);
        clickOnElement(getStarted);
        scrollJS(2000);
        waitForElementToBeClickable(selectBestValuePlanBtn);
        clickOnElement(selectBestValuePlanBtn);
        System.out.println(selectedPlanText.getText().toLowerCase());
    }

    public void wirelessOffer() {
        clickOnElement(wirelessLink);
        scrollJS(2000);
        clickOnElement(iPhone13);
        clickOnElement(mobileColor);
        clickOnElement(continueToCartButton);


    }


    public void accountSignIn(String userName, String password) {
    clickOnElement(accountLink);
    clickOnElement(signInLink);
    sendKeysToInput(userIdField,userName);
    sendKeysToInput(passwordField,password);
    clickOnElement(signInButton);

    }
}
