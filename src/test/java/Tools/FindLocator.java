package Tools;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class FindLocator {
    WebDriver driver;

    public FindLocator(WebDriver driver) {

        this.driver = driver;

    }


    public By to(String locator) {

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
                driver.findElement(x.get(i)).isDisplayed();
                valor = x.get(i);
                break;

            } catch (Exception e) {
                continue;
            }

        }

        System.out.println("valor despues primer for -> " + valor);

        if (valor == null) {
            System.out.println("Buscando en Frame -> " + locator);
            for (int i = 0; i < x.size(); i++) {

                try {
                    if (frame.BuscarFrame(x.get(i))) {
                        System.out.println("Encontre en Frame -> " + x.get(i));
                        driver.findElement(x.get(i)).isDisplayed();
                        valor = x.get(i);
                        break;
                    }

                } catch (Exception e) {
                    continue;

                }
            }
        }

        System.out.println("valor encontrado -> " + valor);
        return valor;
    }
}
