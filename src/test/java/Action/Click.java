package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
                driver.findElement(locator).click();

            } catch (Exception e) {
                System.out.println("No se encontró " + locator);

            }
        }
    }
}




