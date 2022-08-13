package Config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {

    public WebDriver driver;
    public Actions actions;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    @BeforeSuite
    public void beforeAll() {
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.phantomjs().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }


    @AfterTest
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }
//
//
//    @AfterSuite
//    public void afterAll() throws IOException {
//
//        Desktop.getDesktop().open(new File("TestReport/Test-Automaton-Report.html"));
//        Log.info("Tests are ending!");
//    }


}