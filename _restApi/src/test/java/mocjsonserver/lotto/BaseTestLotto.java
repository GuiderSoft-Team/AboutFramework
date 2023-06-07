package mocjsonserver.lotto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestLotto {

    protected RequestSpecification request;
    protected ExtentReports extent = new ExtentReports();
    protected ExtentTest logger;



    @BeforeTest(description = "Report initialization")
    public void beforeTest() {
        RestAssured.baseURI = "http://localhost:3000";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("src/test-output/rest/ExtentReportLotto.html");

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
