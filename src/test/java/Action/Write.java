package Action;


import Tools.FindLocator;
import Tools.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        }
    }


    public void on(String strLocator, String text) {
        WaitFor waitFor = new WaitFor(driver);
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

        try {
            waitFor.explicitWaitOption(locator, 1).click();
            waitFor.explicitWaitOption(locator, 1).sendKeys(text);

        } catch (Exception e) {
            System.out.println("Write - No se encontró " + locator);
        }
    }


}



