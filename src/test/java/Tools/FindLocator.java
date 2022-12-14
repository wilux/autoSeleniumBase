package Tools;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


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

        By valor = null;

        valor = find(locator);

        if (Objects.isNull(valor)) {
            System.out.println("Estoy por reintentar con valor -> " + valor);

            for (int i = 3; i < 8; i++) {

                System.out.println("Locator " + locator + " No encontrado en primer vuelta");
                System.out.println(i + " Reintento...");
                driver.manage().timeouts().implicitlyWait(i * 100, TimeUnit.MILLISECONDS);
                valor = find(locator);
                if (!Objects.isNull(valor)) {
                    System.out.println("Valor final encontrado -> " + valor);
                    driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
                    break;
                }
            }

        }
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        System.out.println("Valor final devuelto -> " + valor);
        return valor;
    }

    private By find(String locator) {

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
                    System.out.println("Acertado con: " + x.get(i));
                    valor = x.get(i);
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error con: " + x.get(i));
                continue;
            }

        }

//        System.out.println("valor despues primer for -> " + valor);

        if (valor == null && frame.sizeFrames() > 0) {  // Si no encontro y existen iframes
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
        return valor;
    }


}
