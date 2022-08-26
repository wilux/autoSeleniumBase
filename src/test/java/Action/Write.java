package Action;


import Tools.FindLocator;
import Tools.WaitFor;
import Tools.WriteLogToFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class Write {
    WebDriver driver;


    public Write(WebDriver driver) {

        this.driver = driver;

    }


    public void on(By locator, String text) throws InterruptedException {
        WaitFor waitFor = new WaitFor(driver);
        FindLocator findLocator = new FindLocator(driver);

        if (findLocator.to(locator)) {
            waitFor.explicitWaitOption(locator, 1).click();
            waitFor.explicitWaitOption(locator, 1).sendKeys(text);

        } else {
            System.out.println("Write - No se encontró " + locator);
            Assert.fail();
        }
    }


    public void on(String strLocator, String text) throws IOException {
        WaitFor waitFor = new WaitFor(driver);
        Click click = new Click(driver);
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);
        WriteLogToFile writeLogToFile = new WriteLogToFile();

        try {
            waitFor.explicitWaitOption(locator, 1).click();
            waitFor.explicitWaitOption(locator, 1).sendKeys(text);
            writeLogToFile.write(strLocator);

        } catch (Exception e) {
            System.out.println("Write - No se encontró " + locator);
            System.out.println("Reintentando paso anterior");
            try {
                click.on(writeLogToFile.read());
                on(strLocator, text);

            } catch (Exception h) {
                System.out.println("No funciono paso panterior... saliendo");
                Assert.fail();
            }
        }
    }


}



