package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        }
    }

    public void on(String strLocator) {

        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);


        if (locator != null) {
            try {
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                driver.switchTo().parentFrame();
            } catch (Exception e) {
                System.out.println("No se encontró " + locator);

            }
        }
    }
}




