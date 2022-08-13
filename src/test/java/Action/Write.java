package Action;


import Tools.FindLocator;
import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Write {
    WebDriver driver;
    int seconds = 5;

    public Write(WebDriver driver) {

        this.driver = driver;
        this.seconds = seconds;

    }


    public void on(String strLocator, String text, int seconds) throws InterruptedException, AWTException {
        this.seconds = seconds;
        on(strLocator, text);
    }

    public void on(String strLocator, String text) throws InterruptedException {
        Thread.sleep(200);
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        final Stopwatch stopwatch = Stopwatch.createStarted();
        boolean estado = false;
        while ((stopwatch.elapsed(TimeUnit.SECONDS) < seconds)) {

            try {
                driver.findElement(locator).click();
                Thread.sleep(200);
                driver.findElement(locator).sendKeys(text);
                estado = true;
                break;
            } catch (Exception e) {
                System.out.println("No se encontró " + locator);
                System.out.println("Reintentando busqueda de Elemento  " + locator);
                System.out.println("Tiempo " + stopwatch.elapsed(TimeUnit.SECONDS));
                continue;
            }
        }
        if (!estado) {
            System.out.println("No se encontró " + locator + " y no se puede continuar prueba.");
            Assert.fail();
        } else {
            Thread.sleep(200);
        }

    }


}


