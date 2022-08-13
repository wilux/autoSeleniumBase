package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;


public class LeadSherpaTest extends BaseTest {


    @Test
    public void dragAndDropTest() throws InterruptedException {

        //Go To
        driver.get("https://app.leadsherpa.com/login");

        actions.write().on("//input[@name='username']", "dont_know");
        actions.write().on("//input[@name='password']", "dont_know");
        actions.keyboard().enter();

    }


}

