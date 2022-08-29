package TestSuits.TestNGTest.Suit1;

import Config.ActionsImp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static Tools.ScreenRecorderUtil.startRecord;
import static Tools.ScreenRecorderUtil.stopRecord;


public class ExampleTestWithVideoRecord extends ActionsImp {
    WebDriver driver;

    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void SearchNameTest() throws Exception {

        startRecord("Test1");

        //Go To
        driver = getDriver();
        driver.get("https://freelancersargentinos.com/");


        write().on("[name='title']", "Nose");
        click().on("button.btn");
        click().on("//a[contains(.,'Ver Perfil')]");
        Assert.assertTrue(get().textOnTag(".fr-c-detail-box > p").equals("Nose"));

        stopRecord();
    }


}

