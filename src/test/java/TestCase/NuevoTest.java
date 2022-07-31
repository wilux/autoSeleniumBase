package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;
import java.awt.*;


public class NuevoTest extends BaseTest{


    @Test
    public void BpnPageTest() throws InterruptedException, AWTException {

        //Go To
        driver.get("https://www.compraypunto.com.ar/");

        write.on("txtUsuario", "");
        write.on("txtClave", "");
        click.on("btnLogIn");
        click.on("SALIR");


    }


}

