package Tools;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FindLocator {
    WebDriver driver;
    int seconds = 20;

    public FindLocator(WebDriver driver) {

        this.driver = driver;

    }

    public FindLocator(WebDriver driver, int seconds) {

        this.driver = driver;
        this.seconds = seconds;

    }


    public By to(String locator) {

        By valor = null;

        final Stopwatch stopwatch = Stopwatch.createStarted();


        while ((stopwatch.elapsed(TimeUnit.SECONDS) < seconds)) {

            try {
                driver.findElement(By.id(locator)).isDisplayed();
                valor = By.id(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.id");

            }

            try {
                driver.findElement(By.name(locator)).isDisplayed();
                valor = By.name(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.name");
            }

            try {
                driver.findElement(By.cssSelector(locator)).isDisplayed();
                valor = By.cssSelector(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.cssSelector");
            }

            try {
                driver.findElement(By.xpath(locator)).isDisplayed();
                valor = By.xpath(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.xpath");
            }

            try {
                driver.findElement(By.linkText(locator)).isDisplayed();
                valor = By.linkText(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.linkText");
            }

            try {
                driver.findElement(By.partialLinkText(locator)).isDisplayed();
                valor = By.partialLinkText(locator);
                break;
            } catch (Exception e) {
                System.out.println("Not found " + locator + " By.partialLinkText");
            }
        }

        return valor;
    }
}
