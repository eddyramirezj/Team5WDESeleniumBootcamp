package testPom;

import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {

    @Test
    public void navigateToLogin() {
        getHomepage().navigateToLogin();
    }

}
