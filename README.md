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

Un test unitario o aislado se crea solo como clase y el metodo se le agrega el decordaor @Test de TestNG
![image](https://user-images.githubusercontent.com/850505/187942410-7380dc79-7581-4266-a94c-eb4066f53d56.png)

de esa forma es posible correcto directamente desde el IDE si se quisiera. 

### TestSuits

Es para ordenar Test en Suits. Una Suit esta conformada por un archivo XML de TestNG el cual se configura para correr
todos los test deseados de la suit. Podría ser para multiples browsers, de forma paralela, etc.

![image](https://user-images.githubusercontent.com/850505/187941281-20f24f10-0311-4634-9ace-f1c8e04ff343.png)

En el ejemplo Suit3, se usa la estructura usando el patron Page Object. Es un ejemplo, de que se puede utilizar pero no es obligación.


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

## Frame
Busca locator de forma recursiva en todos los frames de una página.

## ScreenRecorder 
Graba un video de la prueba y guarda en test-recordings
![image](https://user-images.githubusercontent.com/850505/187944048-d7abf001-d7de-4142-85d4-7038f8acb084.png)
https://user-images.githubusercontent.com/850505/187945264-43d6a4b3-e292-4d99-93d3-99df7e1ede88.mp4

# src/test/

## TestReports

Guarda los reportes generado en las pruebas cuando se corren desde XML con TestNG

![image](https://user-images.githubusercontent.com/850505/187942947-a004a503-7ca6-418b-a9b8-b2815a6d324c.png)
![image](https://user-images.githubusercontent.com/850505/187943715-23f779e4-a125-42a0-9b46-1e4ce9bc44bc.png)
![image](https://user-images.githubusercontent.com/850505/187943665-a5f79d4e-a58a-43ec-9b05-080ef01fbe59.png)



