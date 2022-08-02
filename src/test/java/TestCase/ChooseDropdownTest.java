package TestCase;

import Config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ChooseDropdownTest extends BaseTest {


    @Test
    public void chooseSelectTest() throws InterruptedException {

        //Go To
        driver.get("https://the-internet.herokuapp.com/dropdown");

        choose.byText("dropdown", "Option 1");
        Thread.sleep(2000);
        choose.byText("dropdown", "Option 2");

        Assert.assertTrue(choose.getSelectedValueText("dropdown").equals("Option 2"));

    }


}

