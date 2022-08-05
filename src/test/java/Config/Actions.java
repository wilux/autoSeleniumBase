package Config;

import Action.*;
import org.openqa.selenium.WebDriver;


public class Actions {


    WebDriver driver;


    public Actions(WebDriver driver) {
        this.driver = driver;


    }

    public Click click() {
        Click click = new Click(driver);
        return click;
    }

    public Write write() {
        Write write = new Write(driver);
        return write;
    }

    public CheckBox checkBox() {
        CheckBox checkBox = new CheckBox(driver);
        return checkBox;
    }

    public Choose choose() {
        Choose choose = new Choose(driver);
        return choose;
    }

    public Keyboard keyboard() {
        Keyboard keyboard = new Keyboard(driver);
        return keyboard;
    }


    public LinkStatus linkStatus() {
        LinkStatus linkStatus = new LinkStatus(driver);

        return linkStatus;
    }

    public DragDrop dragDrop() {
        DragDrop dragDrop = new DragDrop(driver);
        return dragDrop;
    }

    public Get get() {
        Get get = new Get(driver);
        return get;
    }

}
