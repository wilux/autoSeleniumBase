package Action;

import Tools.FindLocator;
import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Click {
    WebDriver driver;
    int seconds = 5;


    public Click(WebDriver driver) {

        this.driver = driver;
        this.seconds = seconds;

    }


    public void on(String strLocator, int seconds) throws InterruptedException {
        this.seconds = seconds;
        on(strLocator);
    }


    public void on(String strLocator) throws InterruptedException {

        Thread.sleep(200);
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);
        final Stopwatch stopwatch = Stopwatch.createStarted();
        boolean estado = false;

        if (locator != null) {
            while ((stopwatch.elapsed(TimeUnit.SECONDS) < seconds)) {
                if (driver.findElement(locator).isDisplayed()) {
                    try {
                        driver.findElement(locator).click();
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
            }
        } else {

            // Assert.fail ( "No se encontró " + locator + " y no se puede continuar prueba." );
            System.out.println("No se encontró " + locator + " y no se puede continuar prueba.");
        }
    }

}

