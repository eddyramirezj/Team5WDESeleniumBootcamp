package testPom;

import org.testng.annotations.Test;
import pom.Homepage;
import pom.SignInpage;
import testBase.TestBase;

public class TestSignInpage extends TestBase {





    @Test(enabled = true)
    public void testLoginFunctionality3(){
        Homepage homepage = new Homepage();
        homepage.goToSignInpage();

        SignInpage signInpage = new SignInpage();
        signInpage.enterLoginInfo3();


//        verifyTrue(signInpage.isUsernameCorrect());

    }

    @Test(enabled = true)
    public void testLoginFunctionality2(){
        Homepage homepage = new Homepage();
        homepage.goToSignInpage();

        SignInpage signInpage = new SignInpage();
        signInpage.enterLoginInfo2();


//        verifyTrue(signInpage.isUsernameCorrect());

    }

    @Test(enabled = false)
    public void testLoginFunctionality(){
        Homepage homepage = new Homepage();
        homepage.goToSignInpage();

        SignInpage signInpage = new SignInpage();
        signInpage.enterLoginInfo();


//        verifyTrue(signInpage.isUsernameCorrect());

    }





}
