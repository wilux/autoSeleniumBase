package TestCase;

import Config.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;


public class NuevoTest extends BaseTest {


    @Test(priority = 0)
    public void chargeTest() throws InterruptedException, AWTException {

        //Go To
        driver.get("https://sanbox.undostres.com.mx/");

        write.on("//*[@name='mobile']", "8465433546");
        click.on("//*[@name='operator']");
        click.on("//b[text()='Telcel']");
        click.on("//div[contains(text(), '$10 saldo +$2 de regalo y 500 MB gratis para redes. Vigencia saldo: 7 días. Vigencia redes: 5 días. T&C en Telcel.')]");
        click.on("(//button[text()='Siguiente'])[1]");
        Assert.assertTrue(get.textOnTag("//div[text()='Resumen de la compra']").equals("Resumen de la compra"));


    }

    @Test(priority = 1, dependsOnMethods = "chargeTest")
    public void paymentTest() throws InterruptedException, AWTException {

        click.on("//p[text()='Tarjeta']");
        click.on("//span[text()='Usar nueva tarjeta']");
        write.on("cardnumberunique", "4111111111111111");
        write.on("//input[attribute::data-qa='mes-input']", "11");
        write.on("//input[attribute::data-qa='expyear-input']", "25");
        write.on("//input[attribute::data-qa='cvv-input']", "111");
        write.on(".email", "test@test.com");
        click.on("//button[@id='paylimit']/span[@class='PaymentMethod']");

        //  A popup will appear.
        Assert.assertTrue(get.visible("//div[text()='Para pagar por favor Regístrate o Ingresa a tu cuenta']"));
    }

    @Test(priority = 2, dependsOnMethods = "paymentTest")
    public void popupRegisterTest() throws InterruptedException, AWTException {
        //  A popup will appear. Enter the following email automationUDT1@gmail.com and password “automationUDT123”
        write.on("usrname", "automationUDT1@gmail.com");
        write.on("psw", "automationUDT123");

        //frame recapcha
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        click.on("recaptcha-anchor");
        driver.switchTo().defaultContent();

        //Login
        click.on("loginBtn");

        //Wait

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.urlContains("confirmation/success"));


        // Verify if the user gets a success message and recharge gets successful.
        Assert.assertTrue(driver.getCurrentUrl().contains("confirmation/success"));

    }


}

