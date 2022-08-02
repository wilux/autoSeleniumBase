package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;


public class AddRemoveElementTest extends BaseTest {


    @Test
    public void addRemoveTest() throws InterruptedException, AWTException {

        //Go To
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < 4; i++) {
            click.on("//button[text()='Add Element']");
        }
        for (int i = 0; i < 4; i++) {
            click.on("//button[text()='Delete']");
        }

    }


}

