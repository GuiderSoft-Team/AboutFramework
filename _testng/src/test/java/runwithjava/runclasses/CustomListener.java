package runwithjava.runclasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener {

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("Completed Entire Execution");
        Reporter.log("Completed Entire Execution");
    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("Starting TestNG Execution");
        Reporter.log("Starting TestNG Execution");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("Inside onTestFailure");
        Reporter.log("Inside onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("Starting test case " + arg0.getMethod().getMethodName());
        Reporter.log("Starting test case " + arg0.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("Test success , test case name : " + arg0.getMethod().getMethodName());
        Reporter.log("Test success , test case name : " + arg0.getMethod().getMethodName());

    }

}
