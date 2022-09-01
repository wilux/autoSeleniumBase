package Tests;

import Config.ActionsImp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *  Here Example Alone test with Automatic Locator Search for clicks, write, etc.
 * */
public class AloneExampleTest extends ActionsImp {
    WebDriver driver;


    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void SearchNameTest() throws IOException {

        //Get Driver
        driver = getDriver();

        //Go To
        driver.get("https://www.google.com/");

        //Actions
        write().on("//input[@name='q']", "freelancersargentinos.com");
        click().on("(//input[@aria-label='Buscar con Google'])[2]");
        click().on("//h3[.='Freelancers Argentinos – Otro sitio realizado con WordPress']");

        //Assert
        Assert.assertTrue(get().textOnTag("//h1[.='Freelancers Argentinos']").contains("Freelancers Argentinos"));


    }


}

