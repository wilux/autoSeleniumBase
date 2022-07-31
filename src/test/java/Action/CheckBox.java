package Action;


import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    WebDriver driver;


    public CheckBox(WebDriver driver) {

        this.driver = driver;


    }


    public void check(String strLocator) {

        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

            WebElement checkBoxSelected = driver.findElement(locator);
            WebElement checkBoxDisplayed = driver.findElement(locator);

            boolean isSelected = checkBoxSelected.isSelected();
            boolean isDisplayed = checkBoxDisplayed.isDisplayed();

            if (!isSelected && isDisplayed) {
                checkBoxSelected.click();
            }

        }



    public void unCheck (String strLocator) {

        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

            WebElement checkBoxSelected = driver.findElement(locator);
            WebElement checkBoxDisplayed = driver.findElement(locator);

            boolean isSelected = checkBoxSelected.isSelected();
            boolean isDisplayed = checkBoxDisplayed.isDisplayed();

            if (isSelected && isDisplayed) {
                checkBoxSelected.click();
            }
   }
    }

