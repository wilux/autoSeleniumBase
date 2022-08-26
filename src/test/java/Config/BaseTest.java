package Config;


import Tools.DownloadDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


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
    public void beforeAll(String browserName) {

        DownloadDriver downloadDriver = new DownloadDriver();
        driver = downloadDriver.get(browserName);
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