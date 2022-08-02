package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Choose {
    WebDriver driver;


    public Choose(WebDriver driver) {

        this.driver = driver;

    }

    public void byText(String strLocator, String text) throws InterruptedException {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        driver.findElement(locator).click();
        Thread.sleep(200);
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
        Thread.sleep(200);

    }

    public String getSelectedValueText(String strLocator) {
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);
        WebElement t = driver.findElement(locator);
        Select select = new Select(t);
        WebElement o = select.getFirstSelectedOption();
        return o.getText();
    }

}

