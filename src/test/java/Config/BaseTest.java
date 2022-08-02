package Config;


import Action.*;
import Tools.FindLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.awt.*;


public abstract class BaseTest {

    public WebDriver driver;
    public Click click;
    public Write write;
    public CheckBox checkBox;
    public Choose choose;
    public Keyboard keyboard;
    public FindLocator findLocator;
    public LinkStatus linkStatus;

    public Get get;

    public DragDrop dragDrop;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    @BeforeSuite
    public void beforeAll() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(true);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        click = new Click(driver);
        write = new Write(driver);
        checkBox = new CheckBox(driver);
        choose = new Choose(driver);
        findLocator = new FindLocator(driver);
        keyboard = new Keyboard();
        linkStatus = new LinkStatus(driver);
        dragDrop = new DragDrop(driver);
        get = new Get(driver);

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