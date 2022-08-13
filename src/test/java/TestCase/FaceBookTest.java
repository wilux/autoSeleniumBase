package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;


public class FaceBookTest extends BaseTest {


    @Test(priority = 0)
    public void loginTest() throws InterruptedException, AWTException {

        //Go To
        driver.get("https://facebook.com/");

        actions.write().on("email", "enilde@live.com");
        actions.write().on("pass", "Cogito78");
        actions.click().on("login");

//        actions.waitFor().explicitWait("a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5", 30).click();
        actions.click().on("Amigos");
//        actions.click().on("Grupos");
        actions.click().on("//*[@id='mount_0_0_fN']/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg");
        actions.click().on("//span[.='Cerrar sesión']");


    }


}

