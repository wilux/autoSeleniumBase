package Config;


import Action.Choose;
import Action.Click;
import Action.Keyboard;
import Action.Write;
import Tools.FindLocator;

import Tools.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class BaseTest {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }
    public Click click;
    public Write write;

    public Choose choose;
    public Keyboard keyboard;

    public FindLocator findLocator;


    @BeforeSuite
    public void beforeAll() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click = new Click(driver);
        write = new Write(driver);
        choose = new Choose(driver);
        findLocator = new FindLocator(driver);
        keyboard = new Keyboard();

    }


//    @AfterTest
//    public void afterTest() throws IOException {
//
//        if ( driver != null ) {
//            driver.quit ();
//        }
//    }


//    @AfterSuite
//    public void afterAll() throws IOException {
//
//        Desktop.getDesktop ().open ( new File( "TestReport/Test-Automaton-Report.html" ) );
//        Log.info ( "Tests are ending!" );
//    }


}