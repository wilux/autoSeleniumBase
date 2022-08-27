package Config;


import Tools.DownloadDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public abstract class BaseTest {

    public WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeAll(@Optional("chrome") String browserName) {


        DownloadDriver downloadDriver = new DownloadDriver();
        driver = downloadDriver.get(browserName);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }


//    @AfterClass
//    public void afterTest() {
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}