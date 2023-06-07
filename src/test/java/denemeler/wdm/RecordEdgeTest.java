package denemeler.wdm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

public class RecordEdgeTest {

    static final int REC_TIMEOUT_SEC = 10;
    static final int POLL_TIME_MSEC = 100;
    static final String REC_FILENAME = "myRecordingEdge";
    static final String REC_EXT = ".webm";

    WebDriver driver;
    File targetFolder;
    WebDriverManager wdm = WebDriverManager.edgedriver().watch();

    @BeforeTest
    void setup() {
        driver = wdm.create();
        targetFolder = new File(System.getProperty("user.home"), "Downloads");
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        wdm.startRecording(REC_FILENAME);

        // 1 + 3
        driver.findElement(By.xpath("//span[text()='1']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='3']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        // ... should be 4, wait for it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.className("screen"), "4"));

        wdm.stopRecording();

        long timeoutMs = System.currentTimeMillis()
                + TimeUnit.SECONDS.toMillis(REC_TIMEOUT_SEC);

        File recFile;
        do {
            recFile = new File(targetFolder, REC_FILENAME + REC_EXT);
            if (System.currentTimeMillis() > timeoutMs) {
                fail("Timeout of " + REC_TIMEOUT_SEC
                        + " seconds waiting for recording " + recFile);
                break;
            }
            Thread.sleep(POLL_TIME_MSEC);

        } while (!recFile.exists());

    }
}
