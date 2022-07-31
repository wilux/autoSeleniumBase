package TestCase;

import Config.BaseTest;
import org.testng.annotations.Test;
import java.awt.*;


public class NuevoTest extends BaseTest{


    @Test
    public void Test() throws InterruptedException, AWTException {

        //Go To
        driver.get("http://ksms.mx/libertadqa/login/auth?format=");

        write.on("username", "tester");
        write.on("password", "Mexico.2081");
//        click.on(".loginButton", 50);

//        //Perfilador
//        click.on("li:nth-child(2) img");
//        click.on("clienteNo");
//        click.on("tipoDeDocumento");
//        choose.byText("tipoDeDocumento", "Recibos de nómina con CFDI");
//        click.on("avanzarPerfilador");
//
//        // 1 - Datos Personales
//        write.on("cliente_nombre", "Luis");
//        write.on("cliente_segundoNombre", "Oscar");
//        write.on("cliente_apellidoPaterno", "Flores");
//        write.on("cliente_apellidoMaterno", "Alvarez");
//        write.on("emailCliente_emailPersonal", "luis@mail.com");
//        write.on("telefonoCliente_telefonoCelular", "1111111111");
//        click.on(" //button[@class='confirm']");
//        write.on("cliente_codigoVerificacion", "5555");
//        write.on("telefonoCliente_telefonoCasa", "1111111111");
//        choose.byText("cliente_fechaDeNacimiento_dia", "2");
//        choose.byText("cliente_fechaDeNacimiento_mes", "Febrero");
//        choose.byText("cliente_fechaDeNacimiento_anio", "1971");
//        choose.byText("cliente_genero", "Hombre");
//        choose.byText("cliente_nacionalidad", "MEXICO");
//        choose.byText("cliente_lugarDeNacimiento", "AGUASCALIENTES");
//        click.on("siguiente");

    }


}

