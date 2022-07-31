package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;


public class CheckBoxesTest extends BaseTest {


    @Test
    public void CheckTest() throws InterruptedException, AWTException {

        //Go To
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkBox.check("//*[@id=\"checkboxes\"]/input[1]");
        checkBox.unCheck("//*[@id=\"checkboxes\"]/input[2]");

    }


}

