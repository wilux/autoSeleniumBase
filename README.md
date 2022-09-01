# Template para Pruebas Automatizadas con Selenium y/o TestNG con Java

## El template cuenta con varios paquetes y clases de ejemplo

Estoy utilizando IntelliJ Community Edition como IDE, Maven y Java 18

## La estructura es la siguiente:

src/test/java

### Config
![image](https://user-images.githubusercontent.com/850505/187938402-0a9336bb-def2-4aeb-bc1c-0a2fc305e1e2.png)


Cuenta con clases relacionadas con la configuración.

#### ActiosImp implementa Acciones para ser usadas en los tests.

#### BaseTest es la base para todos los test con Selenium

#### Drivers contiene los drivers posibles a utilizar.

### Actions

![image](https://user-images.githubusercontent.com/850505/187938322-79d20f45-fe6b-40dd-9b0b-9f6aeea19057.png)


Consta de clases con acciones predefinidas para lograr la acción determinada con agregados para reducir código a la hora
de escribir el test. No es obligatorio su uso.

### Tests

Es para escribir test aislados (Fuera de una suit). Cada Clase representa un Test. Un test podría contener varios test en una misma clase
interelacionados.

### TestSuits

Es para ordenar Test en Suits. Una Suit esta conformada por un archivo XML de TestNG el cual se configura para correr
todos los test deseados de la suit. Podría ser para multiples browsers, de forma paralela, etc.

![image](https://user-images.githubusercontent.com/850505/187941281-20f24f10-0311-4634-9ace-f1c8e04ff343.png)


### Tools

Contiene clases con herramientas.

FindLocator -> Busca recursivamente un locator cuando no se pasa el tipo (id, name, xpath, etc).
Esta clase está en proceso de desarrollo su funcionamiento es inestable.

### Ejemplo:

Write y Click usan FindLocator internamente, cuando escribo la prueba en vez de usar.

## Forma Normal:

```sh
        driver.findElement(By.name("inputName1")).sendKeys("Text");
        driver.findElement(By.cssName("button.btn")).click();
        driver.findElement(By.xpath("//a[contains(.,'Ver Perfil')]")).click();
```

## Con FindLocator:

```sh

        write().on("inputName1", "Text");
        click().on("button.btn");
        click().on("//a[contains(.,'Ver Perfil')]");
```

## DownloadDriver

Se utiliza para hacer la descarga automática del driver necesario según el browser que se desea utilizar
en la prueba.
Frame Busca locator de forma recursiva en todos los frames de una página.
ScreenRecorder Graba un video de la prueba y guarda en test-recordings

src/test/

## TestReports

Guarda los reportes generado en las pruebas cuando se corren desde XML con TestNG


