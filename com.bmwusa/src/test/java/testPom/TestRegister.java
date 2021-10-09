package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Register;
import testBase.TestBase;

public class TestRegister extends TestBase {

    @Test (dataProvider = "registerValidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccount(String first_name, String last_name, String email, String password1, String password2){
        getRegister().clickOnRegisterAccount().sendKeysToFirstNameField(first_name).sendKeysToLastNameField(last_name)
                        .sendKeysToEmailField(email).sendKeysToPasswordField(password1)
                        .sendKeysToConfirmPasswordField(password2).clickOnTermsAndConditionsCheckbox().clickOnRegisterNowBtn();

        Assert.assertTrue(isElementPresent(getRegister().registrationConfirmationMsg));
    }

    @Test (dataProvider = "invalidEmailTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccountWithInvalidEmail(String first_name, String last_name, String email, String password1, String password2){
        getRegister().clickOnRegisterAccount().sendKeysToFirstNameField(first_name).sendKeysToLastNameField(last_name)
                .sendKeysToEmailField(email).sendKeysToPasswordField(password1)
                .sendKeysToConfirmPasswordField(password2).clickOnTermsAndConditionsCheckbox();

        Assert.assertTrue(isElementPresent(getRegister().registerNowBtnDisabled));
    }

    @Test (dataProvider = "invalidPasswordTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccountWithInvalidPW(String first_name, String last_name, String email, String password1, String password2){
        getRegister().clickOnRegisterAccount().sendKeysToFirstNameField(first_name).sendKeysToLastNameField(last_name)
                .sendKeysToEmailField(email).sendKeysToPasswordField(password1)
                .sendKeysToConfirmPasswordField(password2).clickOnTermsAndConditionsCheckbox();

        Assert.assertTrue(isElementPresent(getRegister().registerNowBtnDisabled));
    }

    @Test (dataProvider = "differentPasswordTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccountWithDifferentPasswords(String first_name, String last_name, String email, String password1, String password2){
        getRegister().clickOnRegisterAccount().sendKeysToFirstNameField(first_name).sendKeysToLastNameField(last_name)
                .sendKeysToEmailField(email).sendKeysToPasswordField(password1)
                .sendKeysToConfirmPasswordField(password2).clickOnTermsAndConditionsCheckbox();

        Assert.assertTrue(isElementPresent(getRegister().registerNowBtnDisabled));
    }

    @Test (dataProvider = "registerValidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testRegisterAnAccountWithoutCheckingTermsAndCondBox(String first_name, String last_name, String email, String password1, String password2){
        getRegister().clickOnRegisterAccount().sendKeysToFirstNameField(first_name).sendKeysToLastNameField(last_name)
                .sendKeysToEmailField(email).sendKeysToPasswordField(password1)
                .sendKeysToConfirmPasswordField(password2);

        Assert.assertTrue(isElementPresent(getRegister().registerNowBtnDisabled));
    }

}
