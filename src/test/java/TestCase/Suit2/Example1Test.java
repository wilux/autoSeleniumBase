package TestCase.Suit2;

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

//        if (driver != null) {
//            driver.quit();
//        }
    }

    @Test(priority = 1)
    public void SearchNameTest() throws IOException {

        //Get Driver
        driver = getDriver();

        //Go To
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");

        //Actions
        click().on("//button[.='Customer Login']");
        choose().byText("//select[@id='userSelect']", "Harry Potter");
        click().on("//button[@class='btn btn-default']");

        //Assert
        Assert.assertTrue(get().textOnTag("//span[@class='fontBig ng-binding']").contains("Harry Potter"));


    }


}

