package Tools;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class FindLocator {
    WebDriver driver;


    public FindLocator(WebDriver driver) {

        this.driver = driver;


    }

    public Boolean to(By locator) {

        Frame frame = new Frame(driver);
        WaitFor waitFor = new WaitFor(driver);
        WebElement element = waitFor.explicitWaitOption(locator, 20);

        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {


            if (frame.buscarFrame(locator)) {
                System.out.println("Encontre iframe -> para  " + locator);
                return true;
            }
            return false;

        }
    }


    public By to(String locator) {

        WaitFor waitFor = new WaitFor(driver);


        By valor = null;
        Frame frame = new Frame(driver);
        ArrayList<By> x = new ArrayList();
        x.add(By.id(locator));
        x.add(By.name(locator));
        x.add(By.cssSelector(locator));
        x.add(By.xpath(locator));
        x.add(By.linkText(locator));
        x.add(By.partialLinkText(locator));


        for (int i = 0; i < x.size(); i++) {

            try {

                if (driver.findElement(x.get(i)).isDisplayed() && driver.findElement(x.get(i)).isEnabled()) {
                    valor = x.get(i);
                    break;
                }

            } catch (Exception e) {
                continue;
            }

        }

//        System.out.println("valor despues primer for -> " + valor);

        if (valor == null) {  // Si no encontro sigue buiscando en los posibles frames
            System.out.println("Valor: " + valor + " entonces buscando en algun iframe el locator " + locator);
            for (int i = 0; i < x.size(); i++) {

                try {
                    if (frame.buscarFrame(x.get(i))) {
                        System.out.println("Encontre por frame " + locator + " en " + x.get(i));
//                        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
//                                .until(ExpectedConditions.elementToBeClickable(x.get(i)));
                        valor = x.get(i);
                        break;
                    }

                } catch (Exception e) {
                    continue;

                }
            }
        }

        System.out.println("valor final encontrado -> " + valor);
        return valor;
    }


}
