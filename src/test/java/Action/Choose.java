package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Choose {
    WebDriver driver;


    public Choose(WebDriver driver) {

        this.driver = driver;

    }

    public void byText(String strLocator, String text) {
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

//        driver.findElement(locator).click();
//
//        Select select = new Select(driver.findElement(locator));
//        select.selectByVisibleText(text);


        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            w.until(ExpectedConditions
                    .presenceOfNestedElementsLocatedBy
                            (locator, By.tagName("option")));
            // identify dropdown
            WebElement l = driver.findElement(locator);
            // select option by Select class
            Select s = new Select(l);
            // selectByVisibleText to choose an option
            s.selectByVisibleText(text);
        } catch (Exception e) {
            System.out.println("Options not available");
            Assert.fail();
        }

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

