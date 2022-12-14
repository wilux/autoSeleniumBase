package Action;

import Tools.FindLocator;
import Tools.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
                System.out.println("No se encontrĂ³ " + locator);
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
                System.out.println("No se encontrĂ³ " + locator);
            }

        } catch (Exception e) {

        }

        return value;
    }

    public String textOnTag(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        String value = "";


        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            w.until(ExpectedConditions
                    .visibilityOfElementLocated(locator));
            // identify element
            WebElement l = driver.findElement(locator);
            // get text from element
            value = l.getText();
        } catch (Exception e) {
            System.out.println("Element not available");
        }
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
            System.out.println("No se encontrĂ³ " + locator);
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
            System.out.println("No se encontrĂ³ " + locator);
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
            System.out.println("No se encontrĂ³ " + locator);
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
            System.out.println("No se encontrĂ³ " + locator);
        }
        return value;
    }


}


