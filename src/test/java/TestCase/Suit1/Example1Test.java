package TestCase.Suit1;

import Config.ActionsImp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class Example1Test extends ActionsImp {
    WebDriver driver;

    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void SearchNameTest() throws IOException {


        //Go To
        driver = getDriver();
        driver.get("https://freelancersargentinos.com/");


        write().on("[name='title']", "Nose");
        click().on("button.btn");
        click().on("//a[contains(.,'Ver Perfil')]");
        Assert.assertTrue(get().textOnTag(".fr-c-detail-box > p").equals("Nose"));


    }


}

