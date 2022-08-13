package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click {
    WebDriver driver;
    int seconds = 5;


    public Click(WebDriver driver) {

        this.driver = driver;
        this.seconds = seconds;

    }


    public void on(String strLocator) throws InterruptedException {

        Thread.sleep(200);
        FindLocator findLocator = new FindLocator(driver);
        By locator = findLocator.to(strLocator);

        boolean estado = false;

        if (locator != null) {
            if (driver.findElement(locator).isDisplayed()) {
                try {
                    driver.findElement(locator).click();
                    estado = true;
//                        break;
                } catch (Exception e) {
                    System.out.println("No se encontró " + locator);
//                        continue;
                }
            } else {
                System.out.println("Reintentando busqueda de Elemento  " + locator);
//                    continue;
            }
//            }
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

