package Tools;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFor {
    WebDriver driver;


    public WaitFor(WebDriver driver) {

        this.driver = driver;


    }
//    Explicit wait
//    Explicit waits are available to Selenium clients for imperative, procedural languages.
//    They allow your code to halt program execution, or freeze the thread, until the condition you pass
//    it resolves. The condition is called with a certain frequency until the timeout of the wait is elapsed.
//    This means that for as long as the condition returns a falsy value, it will keep trying and waiting.
//    Since explicit waits allow you to wait for a condition to occur, they make a good fit for synchronising
//    the state between the browser and its DOM, and your WebDriver script.
//    To remedy our buggy instruction set from earlier, we could employ a wait to have the findElement call wait until
//    the dynamically added element from the script has been added to the DOM:

    public WebElement explicitWait(By locator, long time) {


        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

        return element;
    }

//    Options
//    The wait condition can be customised to match your needs. Sometimes it is unnecessary to wait the
//    full extent of the default timeout, as the penalty for not hitting a successful condition can be expensive.

    public WebElement explicitWaitOption(By locator, long time) {


        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(time)).
                until(ExpectedConditions.presenceOfElementLocated(locator));

        return element;
    }

//    FluentWait
//    FluentWait instance defines the maximum amount of time to wait for a condition,
//    as well as the frequency with which to check the condition.
//    Users may configure the wait to ignore specific types of exceptions whilst waiting,
//    such as NoSuchElementException when searching for an element on the page.

    public WebElement fluentWait(By locator, long timeOut, int timeEvery) {


        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(timeEvery))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(driver -> driver.findElement(locator));

        return element;
    }


}

