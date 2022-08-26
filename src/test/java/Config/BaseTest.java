package Config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {

    public WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    @BeforeSuite
    public void beforeAll() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();


    }


    @AfterSuite
    public void afterTest() {

//        if (driver != null) {
//            driver.quit();
//        }
    }

}