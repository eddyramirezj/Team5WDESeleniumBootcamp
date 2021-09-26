package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RegisterPage;
import testBase.TestBase;

public class TestRegisterPage extends TestBase {


    @Test (dataProvider = "RegisterValidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccountWithValidData(String test_id, String first_name, String last_name, String password1, String password2, String email_address) {
        RegisterPage registerPage = new RegisterPage();

        getHomepage().navigateToRegisterAccountFromHomepage();
        registerPage.registerAnAccount(first_name, last_name, email_address, password1);

        Assert.assertTrue(isElementPresent(registerPage.greetingsMenu));
    }

    @Test (dataProvider = "RegisterInvalidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testRegisterAnAccountWithInvalidData(String first_name, String last_name, String email_address, String password) {
        RegisterPage registerPage = new RegisterPage();

        getHomepage().navigateToRegisterAccountFromHomepage();
        registerPage.registerAnAccount(first_name, last_name, email_address, password);

        Assert.assertTrue(isElementPresent(registerPage.invalidPasswordErrorMessage));

    }

    @Test (dataProvider = "RegisterBusinessAccountValidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testRegisterABusinessAccountWithValidData(String business, String business_email, String password) {
        RegisterPage registerPage = new RegisterPage();

        getHomepage().navigateToRegisterAccountFromHomepage();
        registerPage.registerBusinessAccount(business, business_email, password);

        Assert.assertTrue(isElementPresent(registerPage.greetingsMenu));

    }

    @Test (dataProvider = "RegisterBusinessAccountInvalidTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testRegisterABusinessAccountWithInvalidData(String business, String business_email, String password) {
        RegisterPage registerPage = new RegisterPage();

        getHomepage().navigateToRegisterAccountFromHomepage();
        registerPage.registerBusinessAccount(business, business_email, password);

        Assert.assertTrue(isElementPresent(registerPage.invalidBusinessPasswordErrorMessage));

    }

}
