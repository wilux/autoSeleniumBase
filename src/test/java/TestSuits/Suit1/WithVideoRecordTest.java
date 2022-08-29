package TestSuits.Suit1;

import Config.ActionsImp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static Tools.ScreenRecorderUtil.startRecord;
import static Tools.ScreenRecorderUtil.stopRecord;


public class WithVideoRecordTest extends ActionsImp {
    WebDriver driver;

    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void SearchNameTest() throws Exception {

        //Get Driver
        driver = getDriver();

        //Start record Video with name "Test1"
        startRecord("Test1");

        //Go To Url
        driver.get("https://freelancersargentinos.com/");

        //Actions
        write().on("[name='title']", "Nose");
        click().on("button.btn");
        click().on("//a[contains(.,'Ver Perfil')]");

        //Assert
        Assert.assertEquals(get().textOnTag(".fr-c-detail-box > p"), "Nose");

        //Stop record video
        stopRecord();
    }


}

