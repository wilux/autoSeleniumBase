package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;


public class DragAndDropTest extends BaseTest {


    @Test
    public void dragAndDropTest() throws InterruptedException {

        //Go To
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        actions.dragDrop().fromAtoBjs("column-a", "column-b");

    }


}

