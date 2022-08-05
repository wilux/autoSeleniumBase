package TestCase;

import Config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LinkCheckTest extends BaseTest {


    @Test
    public void LinkBrokenTest() {

        //Go To
        driver.get("https://the-internet.herokuapp.com/broken_images");

        //No Broken
        Assert.assertTrue(actions.linkStatus().verifyUrlActive("//a[.='Elemental Selenium']"));


    }


}

