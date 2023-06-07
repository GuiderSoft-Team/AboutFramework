package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
    }

    public static boolean getScreenShot() {
        String fileName = System.getProperty("user.dir") + "/testOutput/ScreenShot_" + getLocalDateTime() + ".png";
        return getScreenShot(fileName);
    }


    public static boolean getScreenShot(String fileNameWithPath) {
        TakesScreenshot screenshot = ((TakesScreenshot) Driver.getDriver());
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileNameWithPath);
        try {
            FileUtils.copyFile(sourceFile, destFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean getScreenShotOfElement(WebElement element) {
        String fileName = System.getProperty("user.dir") + "/testOutput/Element_" + getLocalDateTime() + ".png";
        return getScreenShotOfElement(element, fileName);
    }

    public static boolean getScreenShotOfElement(WebElement element, String fileNameWithPath) {
        File sourceFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileNameWithPath);
        try {
            FileUtils.copyFile(sourceFile, destFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public static boolean getScreenShotOfDimension(int x, int y, int width, int height) {
        String fileName = System.getProperty("user.dir") + "/testOutput/ScreenPart_" + getLocalDateTime() + ".png";
        return getScreenShotOfDimension(x, y, width, height, fileName);
    }

    public static boolean getScreenShotOfDimension(int x, int y, int width, int height, String fileNameWithPath) {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) Driver.getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(fileNameWithPath);
            BufferedImage screen = ImageIO.read(sourceFile);
            BufferedImage imgPart = screen.getSubimage(x, y, width, height);
            ImageIO.write(imgPart, "png", sourceFile);
            FileUtils.copyFile(sourceFile, destFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }



}
