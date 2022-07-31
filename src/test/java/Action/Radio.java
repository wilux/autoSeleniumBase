package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Radio {
    WebDriver driver;


    public Radio(WebDriver driver) {

        this.driver = driver;

    }

    public void On(By locator, int index) {


        if ( driver.findElement ( locator ).isDisplayed()  ) {
            try {

                int a = driver.findElements ( locator ).size ();

                for (int i = 1; i <= a; i++) {
                    System.out.println ( "Elementos RadioButton " + driver.findElements ( locator ).get ( index ).getText () );
                    System.out.println ( "Click sobre RadioButton " + index );
                    driver.findElements ( locator ).get ( index ).click ();
                }


            } catch (Exception e) {
            }
        }


    }
}


