package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class PDCTests extends BaseTest {


    @Test
    public void loginOktest() {
        rellenarFormularioLogin("carlo", "Segura12323");

        // Encuentra el elemento con texto "Dashboard"
        WebElement errorLabel = driver.findElement
                (By.xpath("//span[contains(@class, '_label_') and text()='Dashboard']"));

        // Validaciones
        softAssert.assertTrue(errorLabel.isDisplayed(), "El label 'Dashboard' no está visible.");
        softAssert.assertEquals(errorLabel.getText(), "Dashboard",
                "El texto del label no es correcto.");

        // Recolecta todos los resultados
        softAssert.assertAll();


        sleep(10000);


    }

    @Test
    public void loginFailtest() {
        rellenarFormularioLogin("carlo", "Segura123");

        Logs.info("veririficando mensaje de error");
        final var errorLAbel = driver.findElement(
                By.xpath("//span[contains(text(),'Contraseña incorrecta')]")
        );

        sleep(800);

        softAssert.assertTrue(errorLAbel.isDisplayed());
        softAssert.assertEquals(errorLAbel.getText(),
                "Contraseña incorrecta. Quedan 4 intentos antes de bloquear su cuenta.");
        softAssert.assertAll();


        sleep(10000);


    }

    @Test
    public void recuperartest() {
        Logs.info("ingresado a PDC");
        ingresarPDC();

        sleep(100);


        WebElement recuperarLink =
                driver.findElement(By.xpath("//a[contains(text(),'Recuperar')]"));

        Logs.info("click recueprar contraseña");
        recuperarLink.click();

        sleep(100);

        Logs.info("Escribiendo Email en recuperar contraseña");
        driver.findElement(By.id("input-field")).sendKeys("carlo123");


        sleep(1000);


    }

    @Test
    public void monitoreotest() {
        rellenarFormularioLogin("carlo", "Segura12323");

        WebElement monitoreoLink =
                driver.findElement(By.xpath("//a[.//span[text()='Monitoreo']]"));

        Logs.info("Haciendo click en monitoreo");
        monitoreoLink.click();

        sleep(10000);


    }

    @Test
    public void consultaDeDatostest() {
        rellenarFormularioLogin("carlo", "Segura12323");

        WebElement consultaDatos =
                driver.findElement(By.xpath("//a[.//span[text()='Consulta de datos']]"));

        Logs.info("Haciendo click en consulta de datos");
        consultaDatos.click();

        sleep(10000);


    }

    private void rellenarFormularioLogin(String username, String password) {

        final var urlpdc = "https://web-kabeli-gldfds-frontend-qa-1.azurewebsites.net/logingit a";

        Logs.info("Navegando a : %s", urlpdc);
        driver.get(urlpdc);

        Logs.info("Escribiendo Username");
        driver.findElement(By.className("input-field")).sendKeys(username);

        WebElement passwordInput =
                driver.findElement(By.className("password"));
        passwordInput.sendKeys(password);

        WebElement iniciarSesion = driver.
                findElement(By.xpath("//span[text()='Iniciar sesión']"));
        iniciarSesion.click();


    }

    private void ingresarPDC() {
        final var urlpdc = "https://web-kabeli-gldfds-frontend-qa-1.azurewebsites.net/login";

        Logs.info("Navegando a : %s", urlpdc);
        driver.get(urlpdc);

    }
}



