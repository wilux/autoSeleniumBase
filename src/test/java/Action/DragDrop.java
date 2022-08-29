package Action;

import Tools.FindLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragDrop {
    WebDriver driver;


    public DragDrop(WebDriver driver) {

        this.driver = driver;

    }


    //Drag and Drop normal option
    public void fromAtoB(String strLocatorA, String strLocatorB) {


        FindLocator findLocator = new FindLocator(driver);
        By locatorA = findLocator.to(strLocatorA);
        By locatorB = findLocator.to(strLocatorB);

        WebElement elementA = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorA));
        elementA.click();

        WebElement elementB = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorB));
        elementB.click();

        WebElement source = elementA;
        WebElement target = elementB;
        // dragAndDrop() method for dragging the element from source to //destination
        Actions a = new Actions(driver);
        a.dragAndDrop(source, target).build().perform();
    }

    //drap and drop using javaScriptExecutor
    public void fromAtoBjs(String strLocatorA, String strLocatorB) {

        FindLocator findLocator = new FindLocator(driver);
        By locatorA = findLocator.to(strLocatorA);
        By locatorB = findLocator.to(strLocatorB);

        WebElement elementA = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorA));
        elementA.click();

        WebElement elementB = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorB));
        elementB.click();

        WebElement source = elementA;
        WebElement target = elementB;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", source, target);
    }

}

