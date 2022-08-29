package Tests;

import Config.ActionsImp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class AloneWithMultipleStepsTest extends ActionsImp {
    WebDriver driver;

    @AfterClass
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }

    //Test 1
    @Test(priority = 1)
    public void chargeTest() throws IOException {

        //Get Driver
        driver = getDriver();

        //Go To
        driver.get("https://sanbox.undostres.com.mx/");

        //Actions
        write().on("//*[@name='mobile']", "8465433546");
        click().on("//*[@name='operator']");
        click().on("//b[text()='Telcel']");
        click().on("//div[contains(text(), '$10 saldo +$2 de regalo y 500 MB gratis para redes. Vigencia saldo: 7 días. Vigencia redes: 5 días. T&C en Telcel.')]");
        click().on("(//button[text()='Siguiente'])[1]");

        //Assert
        Assert.assertTrue(get().textOnTag("//div[text()='Resumen de la compra']").equals("Resumen de la compra"));


    }

    //Test 2 dependent of Test 1
    @Test(priority = 2, dependsOnMethods = "chargeTest")
    public void paymentTest() throws IOException {

        //Actions
        click().on("//p[text()='Tarjeta']");
        click().on("//*[@id='radio-n']/td/label/a");
        write().on("cardnumberunique", "4111111111111111");
        write().on("//input[attribute::data-qa='mes-input']", "11");
        write().on("//input[attribute::data-qa='expyear-input']", "25");
        write().on("//input[attribute::data-qa='cvv-input']", "111");
        write().on(".email", "test@test.com");
        click().on("//button[@id='paylimit']/span[@class='PaymentMethod']");

        //Assert
        Assert.assertTrue(get().visible("//div[text()='Para pagar por favor Regístrate o Ingresa a tu cuenta']"));
    }

    //Test 3 dependent of Test 2
    @Test(priority = 3, dependsOnMethods = "paymentTest")
    public void popupRegisterTest() throws IOException {
        //Actions
        write().on("usrname", "automationUDT1@gmail.com");
        write().on("psw", "automationUDT123");
        click().on("recaptcha-anchor");
        click().on("loginBtn");

        //Assert
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.urlContains("confirmation/success"));
        Assert.assertTrue(driver.getCurrentUrl().contains("confirmation/success"));

    }


}

