package Action;


import Tools.FindLocator;
import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Write {
    WebDriver driver;
    int seconds = 20;

    public Write(WebDriver driver) {

        this.driver = driver;
        this.seconds = seconds;

    }


    public void on(String strLocator, String text, int seconds) throws InterruptedException, AWTException {
        this.seconds = seconds;
        on(strLocator, text);
    }

    public void on(String strLocator, String text) throws InterruptedException, AWTException {
//        Click click = new Click(driver);
        Thread.sleep(200);
        FindLocator findLocator = new FindLocator(driver);

        By locator = findLocator.to(strLocator);

        final Stopwatch stopwatch = Stopwatch.createStarted();
        boolean estado = false;
        while ((stopwatch.elapsed(TimeUnit.SECONDS) < seconds)) {
            if (driver.findElement(locator).isDisplayed()) {
                try {
                    driver.findElement(locator).click();
                    Thread.sleep(200);
                    driver.findElement(locator).sendKeys(text);
                    estado = true;
                    break;
                } catch (Exception e) {
                    System.out.println("No se encontró " + locator);
                    continue;
                }
            } else {
                System.out.println("Reintentando busqueda de Elemento  " + locator);
                System.out.println("Tiempo " + stopwatch.elapsed(TimeUnit.SECONDS));
                continue;
            }
        }
        if (!estado) {
            // Assert.fail ( "No se encontró " + locator + " y no se puede continuar prueba." );
            System.out.println("No se encontró " + locator + " y no se puede continuar prueba.");
        } else {
            Thread.sleep(200);
//            click.on("input");
        }

    }


}


