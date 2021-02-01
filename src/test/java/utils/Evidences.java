package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Evidences {

    public void takesScreenshot(WebDriver driver, String id, String pastaPrint, String nomePrint) throws IOException { //webdriver, driver precisou instanciar o chrome ]driver pq ele esta em outra classe e precisa chamar ele nessa tb

        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto,new File(pastaPrint + "Cenario " + id + "/" + nomePrint + ".png"));
    }

}
