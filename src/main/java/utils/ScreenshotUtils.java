package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {
    private static  int testattempt=0;
//    public static File getScreenshotFile(String fileName){
//        return new File("screenshot/"+fileName +"_"+ (++testattempt)+".png");
//    }


    public static void takeScreenshot(WebDriver driver, String testName){
        try {

            File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileName = testName + "_" + System.currentTimeMillis() + ".png";
            File dest= new File("screenshot/" +fileName);
            Files.createDirectories(dest.getParentFile().toPath());
            Files.copy(src.toPath(),dest.toPath());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
