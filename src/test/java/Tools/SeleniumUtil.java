package Tools;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import java.util.concurrent.TimeUnit;

public class SeleniumUtil {

    private static WebDriver webDriver;

    public static synchronized WebDriver getWebDriver(@Optional("chrome") String browserName) {

        if (webDriver == null) {
            initialize(browserName);
        }
        return webDriver;
    }

    private static void initialize(String browserName) {
        DownloadDriver downloadDriver = new DownloadDriver();
        webDriver = downloadDriver.get(browserName);
        webDriver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        webDriver.manage().window().maximize();
    }
}