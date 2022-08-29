package Action;

import Tools.FindLocator;
import Tools.WriteLogToFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Click {
    WebDriver driver;


    public Click(WebDriver driver) {

        this.driver = driver;


    }

    public void on(By locator) {

        FindLocator findLocator = new FindLocator(driver);
        if (findLocator.to(locator)) {
            driver.findElement(locator).click();

        } else {
            System.out.println("No se encontró " + locator);
            Assert.fail();
        }
    }

    public void on(String strLocator) {
        WriteLogToFile writeLogToFile = new WriteLogToFile();
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            writeLogToFile.write(strLocator);
            try {
                driver.switchTo().parentFrame();
            } catch (Exception i) {
            }

        } catch (Exception e) {
            System.out.println("No se encontró " + locator);
            System.out.println("Reintentando paso anterior");
            try {
                on(writeLogToFile.read());
                on(strLocator);
            } catch (Exception h) {
                System.out.println("No funciono paso anterior... saliendo");
                Assert.fail();
            }

        }

    }
}




