package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Grid {
    WebDriver driver;

    public Grid(WebDriver driver) {

        this.driver = driver;

    }

    public void rowSelectbyText(By locator, String valor) {


        if (driver.findElement(locator).isDisplayed()) {

            try {
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.elementToBeClickable(locator));


                WebElement span = element.findElement(By.xpath("//span[contains(text(),'" + valor + "')]"));

                span.click();


            } catch (Exception e) {
                System.out.println("No encontre " + valor);
                Assert.fail();
            }
        } else {

            System.out.println("No se encontro " + locator + " - " + valor);
            Assert.fail();
        }

    }


    public void rowSelectbyFila(By locator, By fila) {


        if (driver.findElement(locator).isDisplayed()) {

            try {
                WebElement webElement = driver.findElement(locator);
                webElement.findElement(fila).click();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
