package TestCase;

import Config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ImageCheckTest extends BaseTest {


    @Test
    public void ImagesBrokenTest() {

        //Go To
        driver.get("https://the-internet.herokuapp.com/broken_images");

        //Broken 1
        Assert.assertTrue(!linkStatus.verifyImageActive("//*[@id='content']/div/img[1]"));

        //Broken 2
        Assert.assertTrue(!linkStatus.verifyImageActive("//*[@id='content']/div/img[2]"));

        //No Broken 3
        Assert.assertTrue(linkStatus.verifyImageActive("//*[@id='content']/div/img[3]"));

    }


}

