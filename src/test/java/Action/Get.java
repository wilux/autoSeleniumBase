package Action;

import Tools.FindLocator;
import Tools.WaitFor;
import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Get {
    WebDriver driver;


    public Get(WebDriver driver) {

        this.driver = driver;

    }

    public String valueOnInput(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        String value = "";

        try {
            if (driver.findElement(locator).isDisplayed()) {
                value = driver.findElement(locator).getAttribute("value");

            } else {
                value = "";
                System.out.println("No se encontró " + locator);
            }

        } catch (Exception e) {

        }

        return value;
    }

    public String Url(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        String value = "";

        try {
            if (driver.findElement(locator).isDisplayed()) {
                value = driver.findElement(locator).getAttribute("href");

            } else {
                value = "";
                System.out.println("No se encontró " + locator);
            }

        } catch (Exception e) {

        }

        return value;
    }

    public String textOnTag(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        String value = "";

        final Stopwatch stopwatch = Stopwatch.createStarted();

        while ((stopwatch.elapsed(TimeUnit.SECONDS) < 10)) {
            if (driver.findElement(locator).isDisplayed()) {
                value = driver.findElement(locator).getText();
                break;
            } else {
                System.out.println("No se encontró " + locator);
                continue;
            }
        }
        System.out.println(value);
        return value;
    }

    public String valueJS(String strLocator, String id) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = "";


        if (driver.findElement(locator).isDisplayed()) {
            value = (String) js.executeScript("return document.getElementById('" + id + "').innerHTML");
        } else {
            System.out.println("No se encontró " + locator);
        }
        return value;
    }

    public boolean visible(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);


        WaitFor waitFor = new WaitFor(driver);
        try {

            if (waitFor.explicitWait(locator, 20).isDisplayed()) {
                return true;

            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean seleccionado(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);
        boolean value = false;
        if (driver.findElement(locator).isDisplayed()) {
            value = driver.findElement(locator).isSelected();

        } else {
            System.out.println("No se encontró " + locator);
        }
        return value;
    }

    public boolean habilitado(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);
        boolean value = false;
        if (driver.findElement(locator).isDisplayed()) {
            value = driver.findElement(locator).isEnabled();

        } else {
            System.out.println("No se encontró " + locator);
        }
        return value;
    }


    public boolean existe(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);
        boolean value = false;
        if (driver.findElement(locator).isDisplayed()) {
            value = true;
        } else {
            System.out.println("No se encontró " + locator);
        }
        return value;
    }


}


