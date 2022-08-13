package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Captcha {
    WebDriver driver;

    public Captcha(WebDriver driver) {

        this.driver = driver;

    }

    public boolean saltar() {
        String[] tipos = {"@class=", "@id=", "@name=", "@for=", "text()="};


        try {
            List<WebElement> resultList = driver.findElements(By.tagName("iframe"));

            for (WebElement result : resultList) {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(result.getAttribute("name"));
                for (String x : tipos) {
                    try {
                        new WebDriverWait(driver, Duration.ofSeconds(5))
                                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[{" + x + "}'{check}']")));
                        return true;
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
