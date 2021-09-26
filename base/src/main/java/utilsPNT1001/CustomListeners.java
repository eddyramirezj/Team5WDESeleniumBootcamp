package utilsPNT1001;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("The Name of the Testcase: --->>> " + iTestResult.getName() + "  <<<--- STARTED execution.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The Test Case: --->>> " + iTestResult.getName() + "  <<<--- PASSED.");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("The Test Case: --->>>  " + iTestResult.getName() + "  <<<--- FAILED.");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("The Test Case: --->>>  " + iTestResult.getName() + "  <<<--- SKIPPED.");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

        System.out.println("Test Cases located in CLASS: --->>>  " + iTestContext.getName() + " <<<--- STARTED execution.");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test Cases located in CLASS: --->>>  " + iTestContext.getName() + " <<<--- COMPLETED execution.");



    }
}
