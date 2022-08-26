package Tools;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Frame {

    WebDriver driver;


    public Frame(WebDriver driver) {

        this.driver = driver;

    }

    public WebElement findElementIfExists(By by) {
        WebElement element = null;
        final Stopwatch stopwatch = Stopwatch.createStarted();
        do {

            try {
                List<WebElement> elements = driver.findElements(by);
                element = (elements.size() >= 1) ? elements.get(0) : null;
                break;
            } catch (Exception e) {
                continue;
            }

        } while (stopwatch.elapsed(TimeUnit.SECONDS) < 5);

        return element;
    }


    public Boolean buscarFrame(By locator) {
        Boolean estado = false;

        System.out.println("Locator en frame " + locator);
        if (findElementIfExists(locator) != null) {
            estado = true;
        } else {

            try {
                driver.switchTo().defaultContent();
            } catch (Exception e) {
            }

            //String frameI = FrameActual ();
            int sizeInicial = driver.findElements(By.tagName("iframe")).size();
            System.out.println("Cantidad frames: " + sizeInicial);
            for (int i = 0; i < sizeInicial; i++) {


                try {
                    driver.switchTo().frame(i);
                    driver.findElement(locator);
                    estado = true;
                    break;
                } catch (Exception e) {
                    driver.switchTo().parentFrame();
                    continue;
                }

            }

        }

        return estado;
    }


}