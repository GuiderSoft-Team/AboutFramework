package mocjsonserver.db;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestDb {

    static RequestSpecification request;
    static ExtentReports extent = new ExtentReports();
    static ExtentTest logger;

    @BeforeTest(description = "Report initialization")
    public void beforeTest() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("src/test-output/rest/ExtentReport.html");

        extent.setSystemInfo("OS Name", "Windows");
        extent.setSystemInfo("Username", "Guidersoft");
        extent.attachReporter(reporter);

        //Provide the title and description of you test
        logger = extent.createTest("API Test", "Test Tanimi");
    }

    @AfterTest(description = "Finalize report")
    public void afterTest() {
        extent.flush();
    }


}
