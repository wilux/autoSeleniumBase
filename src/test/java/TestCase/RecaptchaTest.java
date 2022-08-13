package TestCase;

import Config.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class RecaptchaTest extends BaseTest {


    @Test
    public void selectCorrectimg() throws InterruptedException, IOException {
        driver.get("https://www.gob.mx/curp/");


        actions.waitFor().explicitWaitOption("curpinput", 5).sendKeys("SAMH580711HDFNRG09");
//        actions.write().on("curpinput", "SAMH580711HDFNRG09");
//        Frame frame = new Frame(driver);
//        frame.buscarFrame(By.xpath("//span[@id='recaptcha-anchor']/div"));


        do {
            actions.waitFor().fluentWait("//span[@id='recaptcha-anchor']/div", 5, 1).click();
        } while (actions.get().visible("#recaptcha-anchor > div.recaptcha-checkbox-checkmark"));


//        if (actions.get().visible("primary-controls")) {
//            // Audio Captcha
//            actions.click().on("//button[@id='recaptcha-audio-button']");
//            System.out.println("Listo el  download");
//            String FILE_URL = actions.get().Url("rc-audiochallenge-tdownload-link");
//
//            InputStream in = new URL(FILE_URL).openStream();
//            Files.copy(in, Paths.get("audio/audio.mp3"), StandardCopyOption.REPLACE_EXISTING);
//            Thread.sleep(5000);
//            Mp3toText mp3toText = new Mp3toText();
//            String result = mp3toText.fileUploadTest("audio/audio.mp3");
//            Thread.sleep(5000);
//            actions.write().on("#audio-response", result);
//            actions.click().on("//button[@id='recaptcha-verify-button']");
//        }
        driver.switchTo().defaultContent();


        actions.click().on("searchButton");

        // tabla Datos del solicitante [letxpath='letxpathtable']
        // tabla datos del documento probatorio //div[@class='col-md-5']//table[1]

//        if (actions.get().visible("alert alert-danger")) {
//            frame.buscarFrame(By.xpath("//span[@id='recaptcha-anchor']/div"));
//            driver.switchTo().defaultContent();
//        }
        actions.click().on("searchButton");
        WebElement table = actions.waitFor().explicitWait("[letxpath='letxpathtable']", 30);
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));

        List<WebElement> columnsList = null;

        System.out.println("Tabla - Datos del solicitante");
        for (WebElement row : rowsList) {
            columnsList = row.findElements(By.tagName("td"));

            for (WebElement column : columnsList) {
                System.out.println("column text - " + column.getText() + ", ");
            }

        }


        //Download pdf
        //actions.click().on("//button[@id='download']");


    }
}
