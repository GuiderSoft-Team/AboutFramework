package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {


    public static void myAssert(String expected, String actual){
        myAssert(expected, actual, true);
    }
    public static void myAssert(String expected, String actual, boolean screenshot){
        if (!expected.equals(actual)){
            if (screenshot) {
                Utils.takeScreenShot();
            }
            throw new RuntimeException("Expected : " + expected + "\nActual :" + actual);
        }

    }

    public static void takeScreenShot(){
        String filePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        filePath = "ScreenShot/" + filePath + ".png";
        takeScreenShot(filePath);
    }


    public static void takeScreenShot(String filePath){
        TakesScreenshot scrShot =((TakesScreenshot) Driver.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createDirectory(String fileWithPath){
        String[] pathArray = fileWithPath.split("/");
        String path = "";
        if (pathArray.length>0) {
            for (int i = 0; i < pathArray.length - 1; i++) {
                path += pathArray[i] + "/";
            }
        }
        File theDir = new File(path);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
