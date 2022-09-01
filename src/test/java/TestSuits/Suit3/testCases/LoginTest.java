package TestSuits.Suit3.testCases;

import Config.ActionsImp;
import TestSuits.Suit3.pages.Login;
import TestSuits.Suit3.pages.Profile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
 *  Here Example Test in Suit without Automatic Locator Search for clicks, write, etc.
 *  You can configure and run Suit1.xml for run all test of suit
 *  This Example use Object Page Pattern
 * */
public class LoginTest extends ActionsImp {
    WebDriver driver;


    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void LoginTest() {

        //Get Driver
        driver = getDriver();

        //General Timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Go To
        driver.get("https://demoqa.com/login");

        //Instantiating Login & Profile page using initElements()
        Login loginPg = PageFactory.initElements(driver, Login.class);
        Profile profilePg = PageFactory.initElements(driver, Profile.class);

        //Using the methods created in pages class to perform actions
        loginPg.LogIn_Action("---your username---", "---your password---");
        profilePg.verifyUser("---your username---");
        profilePg.logout_Action();

        driver.quit();


    }


}

