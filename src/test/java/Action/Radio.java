package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Radio {
    WebDriver driver;


    public Radio(WebDriver driver) {

        this.driver = driver;

    }

    public void On(By locator, int index) {


        if (driver.findElement(locator).isDisplayed()) {
            try {

                int a = driver.findElements(locator).size();

                for (int i = 1; i <= a; i++) {
                    driver.findElements(locator).get(index).click();
                }


            } catch (Exception e) {
            }
        }


    }

    public void On(String strLocator, int index) {
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

        if (locator != null) {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(locator));

            if (driver.findElement(locator).isDisplayed()) {
                try {

                    int a = driver.findElements(locator).size();

                    for (int i = 1; i <= a; i++) {
                        driver.findElements(locator).get(index).click();
                    }


                } catch (Exception e) {
                }
            }


        }
    }
}


