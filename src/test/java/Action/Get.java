package Action;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Get {
    WebDriver driver;


    public Get(WebDriver driver) {

        this.driver = driver;

    }

    public String ValueOnInput(By locator) {
        String value = "";


        try {
            if (  driver.findElement ( locator ).isDisplayed()) {
                value = driver.findElement ( locator ).getAttribute ( "value" );

            }
            else {
                value = "";
                System.out.println ( "No se encontró " + locator );
            }

        } catch (Exception e) {

        }

        return value;
    }

    public String TextOnTag(By locator) {
        String value = "";

        final Stopwatch stopwatch = Stopwatch.createStarted ();

        while ((stopwatch.elapsed ( TimeUnit.SECONDS ) < 10)) {
            if (  driver.findElement ( locator ).isDisplayed()) {
                value = driver.findElement ( locator ).getText ();
                break;
            }
            else {
                System.out.println ( "No se encontró " + locator );
                continue;
            }
        }
        return value;
    }

    public String ValueJS(By locator, String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = "";


        if (  driver.findElement ( locator ).isDisplayed()) {
            value = (String) js.executeScript ( "return document.getElementById('" + id + "').innerHTML" );
        }
        else {
            System.out.println ( "No se encontró " + locator );
        }
        return value;
    }

    public boolean Visible(By locator) {


        boolean value = false;
        if (  driver.findElement ( locator ).isDisplayed()) {
            value = driver.findElement ( locator ).isDisplayed ();

        }
        else {
            System.out.println ( "No se encontró " + locator );
        }
        return value;
    }

    public boolean Seleccionado(By locator) {


        boolean value = false;
        if (  driver.findElement ( locator ).isDisplayed()) {
            value = driver.findElement ( locator ).isSelected ();

        }
        else {
            System.out.println ( "No se encontró " + locator );
        }
        return value;
    }

    public boolean Habilitado(By locator) {


        boolean value = false;
        if ( driver.findElement ( locator ).isDisplayed()) {
            value = driver.findElement ( locator ).isEnabled ();

        }
        else {
            System.out.println ( "No se encontró " + locator );
        }
        return value;
    }


    public boolean Existe(By locator) {


        boolean value = false;
        if ( driver.findElement ( locator ).isDisplayed()) {
            value = true;
        }
        else {
            System.out.println ( "No se encontró " + locator );
        }
        return value;
    }


}


